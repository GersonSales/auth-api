package br.com.gsafj.security;

import br.com.gsafj.exception.InvalidJwtAuthenticationException;
import br.com.gsafj.user.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

  @Value("${security.jwt.token.secret-key:secret}")
  private String secretKey;


  @Value("${security.jwt.token.expire-length:3600}")
  private long validityInMilliseconds;

  private final UserService userDetailsService;

  public JwtTokenProvider(final UserService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @PostConstruct
  public void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(final String username,
                            final List<String> roles) {

    final Claims claims = Jwts.claims().setSubject(username);
    claims.put("roles", roles);

    final Date now = new Date();
    final Date validity = new Date(now.getTime() + this.validityInMilliseconds);

    return Jwts
        .builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public Authentication getAuthentication(final String token) {
    final String username = getUsernameByToken(token);
    final UserDetails userDetails
        = userDetailsService.loadUserByUsername(username);
    return new UsernamePasswordAuthenticationToken(
        userDetails,
        "",
        userDetails.getAuthorities());
  }

  private String getUsernameByToken(final String token) {
    return Jwts
        .parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getSignature();
  }


  public String resolveToken(final HttpServletRequest request) {
    final String bearerToken = request.getHeader("Authorization");

    final String bearer = "Bearer";
    String result = null;
    if (bearerToken != null && bearerToken.startsWith(bearer)) {
      result = bearerToken.substring(bearer.length());
    }


    return result;
  }

  public boolean validateToken(final String token) throws InvalidJwtAuthenticationException {
    try {
      return Jwts.parser()
          .setSigningKey(secretKey)
          .parseClaimsJws(token)
          .getBody()
          .getExpiration()
          .before(new Date());

    } catch (final Exception error) {
      throw new InvalidJwtAuthenticationException();
    }
  }

}

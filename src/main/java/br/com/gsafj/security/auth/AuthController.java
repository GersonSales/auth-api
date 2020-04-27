package br.com.gsafj.security.auth;

import br.com.gsafj.security.jwt.JwtTokenProvider;
import br.com.gsafj.user.UserModel;
import br.com.gsafj.user.UserRepository;
import br.com.gsafj.user.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/auth")
public class AuthController {

  final AuthenticationManager authenticationManager;

  final JwtTokenProvider jwtTokenProvider;

  final UserRepository userRepository;


  public AuthController(final AuthenticationManager authenticationManager,
                        final JwtTokenProvider jwtTokenProvider,
                        final UserRepository userRepository) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenProvider = jwtTokenProvider;
    this.userRepository = userRepository;
  }

  @PostMapping("/auth")
  public ResponseEntity<Map<Object, Object>> authenticate(
      @RequestBody final UserVO userVO) {
    try {
      final String username = userVO.getUserName();
      final String password = userVO.getPassword();

      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(
              username,
              password
          ));

      String token = "";
      final UserModel user = userRepository.findByUserName(username);
      if (user != null) {
        token = jwtTokenProvider.createToken(username, user.getRoles());
      } else {
        throw new UsernameNotFoundException(
            "Username " + username + " not " +"found."
        );
      }

      final Map<Object, Object> model = new HashMap<>();
      model.put("username", username);
      model.put("token", token);

      return ResponseEntity.ok(model);

    } catch (final AuthenticationException exception) {
      throw new BadCredentialsException("Authentication failed.");
    }
  }
}

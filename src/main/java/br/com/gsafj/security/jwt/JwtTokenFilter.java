package br.com.gsafj.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

  final private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void doFilter(final ServletRequest servletRequest,
                       final ServletResponse servletResponse,
                       final FilterChain filterChain) throws IOException,
      ServletException {
    final String token = this.jwtTokenProvider.resolveToken(servletRequest);
    if (token != null && jwtTokenProvider.isAValidToken(token)) {
      final Authentication auth = jwtTokenProvider.getAuthentication(token);
      if (auth != null) {
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }
    filterChain.doFilter(servletRequest, servletResponse);

  }
}

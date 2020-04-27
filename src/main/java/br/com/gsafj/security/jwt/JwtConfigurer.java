package br.com.gsafj.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer
    extends SecurityConfigurerAdapter
    <DefaultSecurityFilterChain, HttpSecurity> {


  final JwtTokenProvider jwtTokenProvider;

  public JwtConfigurer(final JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void configure(final HttpSecurity builder) throws Exception {
    final JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
    builder.addFilterBefore(customFilter,
        UsernamePasswordAuthenticationFilter.class);
  }
}

package br.com.gsafj.config;

import br.com.gsafj.security.jwt.JwtConfigurer;
import br.com.gsafj.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  final private JwtTokenProvider jwtTokenProvider;

  public SecurityConfig(final JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(final HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
          .authorizeRequests()
          .antMatchers("/auth/signIn", "/auth/signUp").permitAll()
          .antMatchers("/api/**").authenticated()
          .antMatchers("/users").denyAll()
        .and()
          .apply(new JwtConfigurer(jwtTokenProvider));

  }
}

package br.com.gsafj.security.auth;

import br.com.gsafj.security.jwt.JwtTokenProvider;
import br.com.gsafj.user.UserRepository;
import br.com.gsafj.user.UserService;
import br.com.gsafj.user.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  final AuthService authService;

  public AuthController(final AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/signIn")
  public ResponseEntity<Map<Object, Object>> signIn(
      @RequestBody final UserVO authVo) {
    try {
      return ResponseEntity.ok(this.authService.authenticate(authVo));
    } catch (final AuthenticationException exception) {
      throw new BadCredentialsException("Authentication failed.");
    }
  }

  @PostMapping("/signUp")
  public ResponseEntity<UserVO> signUp(
      @RequestBody final UserVO authVo) {
    return ResponseEntity.ok(this.authService.create(authVo));
  }


}

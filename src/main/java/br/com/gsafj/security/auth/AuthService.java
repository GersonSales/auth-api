package br.com.gsafj.security.auth;

import br.com.gsafj.security.jwt.JwtTokenProvider;
import br.com.gsafj.user.UserModel;
import br.com.gsafj.user.UserRepository;
import br.com.gsafj.user.UserService;
import br.com.gsafj.user.UserVO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

  final AuthenticationManager authenticationManager;

  final JwtTokenProvider jwtTokenProvider;

  final UserRepository userRepository;

  final UserService userService;

  public AuthService(final AuthenticationManager authenticationManager,
                     final JwtTokenProvider jwtTokenProvider,
                     final UserRepository userRepository,
                     final UserService userService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenProvider = jwtTokenProvider;
    this.userRepository = userRepository;
    this.userService = userService;
  }

  private Map<Object, Object> getRolesMap(String username, String token) {
    final Map<Object, Object> model = new HashMap<>();
    model.put("username", username);
    model.put("token", token);
    return model;
  }

  private void authenticate(String username, String password) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(
            username,
            password
        ));
  }

  private String getTokenByUsername(String username) {
    final UserModel user = userRepository.findByUsername(username);
    if (user != null) {
      return jwtTokenProvider.createToken(username, user.getRoles());
    } else {
      throw new UsernameNotFoundException(
          "Username " + username + " not " + "found."
      );
    }
  }


  public Map<Object, Object> authenticate(final UserVO userVo) {
    final String username = userVo.getUsername();
    final String password = userVo.getPassword();

    authenticate(username, password);
    String token = getTokenByUsername(username);

    return getRolesMap(username, token);
  }

  public UserVO create(final UserVO userVO) {
    userVO.setPassword(this.userService.create(userVO).getPassword());
    return userVO;

  }
}

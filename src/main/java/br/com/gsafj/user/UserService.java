package br.com.gsafj.user;

import br.com.gsafj.exception.MalformedUserInfoException;
import br.com.gsafj.exception.UserNotFoundException;
import br.com.gsafj.util.DataStructureConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {

  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserVO> findAll() {
    return DataStructureConverter.parseAll(
        this.userRepository.findAll(),
        UserVO.class);
  }

  public UserVO findById(final String id) {
    throw new UserNotFoundException();
  }

  public UserVO create(final UserVO userModel) {
    throw new MalformedUserInfoException();
  }

  public void remove(final String id) {
    throw new UserNotFoundException();
  }
}

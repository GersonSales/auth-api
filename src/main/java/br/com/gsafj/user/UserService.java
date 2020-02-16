package br.com.gsafj.user;

import br.com.gsafj.exception.MalformedUserInfoException;
import br.com.gsafj.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.gsafj.util.DataStructureConverter.parseAll;
import static br.com.gsafj.util.DataStructureConverter.parseObject;

@Service(value = "userService")
public class UserService {

  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<UserVO> findAll() {
    return parseAll(
        this.userRepository.findAll(),
        UserVO.class);
  }

  public UserVO findById(final Long id) {
    return parseObject(
        this.userRepository
            .findById(id)
            .orElseThrow(UserNotFoundException::new),
        UserVO.class);
  }

  public UserVO create(final UserVO userVO) {
    final UserModel userModel = parseObject(userVO, UserModel.class);
    return parseObject(this.userRepository.save(userModel), UserVO.class);
  }

  public void remove(final Long id) {
    if (this.userRepository.existsById(id)) {
      this.userRepository.deleteById(id);
    } else {
      throw new UserNotFoundException();
    }

  }

  public UserVO update(final UserVO userVO) {
    if (this.userRepository.existsById(userVO.getId())) {
      return parseObject(
          this.userRepository
              .save(parseObject(userVO, UserModel.class)),
          UserVO.class);
    } else {
      throw new UserNotFoundException();
    }
  }
}

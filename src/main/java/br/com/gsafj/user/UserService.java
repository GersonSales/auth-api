package br.com.gsafj.user;

import br.com.gsafj.exception.MalformedUserInfoException;
import br.com.gsafj.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserService {
  public List<UserModel> findAll() {
    return new ArrayList<UserModel>();

  }

  public UserModel findById(final String id) {
    throw new UserNotFoundException();
  }

  public UserModel create(final UserModel userModel) {
    throw new MalformedUserInfoException();
  }

  public void remove(final String id) {
    throw new UserNotFoundException();
  }
}

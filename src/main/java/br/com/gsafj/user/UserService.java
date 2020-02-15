package br.com.gsafj.user;

import br.com.gsafj.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserService {
  public List<UserModel> findAll() {
    ArrayList<UserModel> userModels = new ArrayList<UserModel>();
    userModels.add(new UserModel());
    return userModels;

  }

  public UserModel findById(final String id) {
    throw new UserNotFoundException();
  }

  public UserModel create(UserModel userModel) {
    return null;
  }

  public void remove(String id) {

  }
}

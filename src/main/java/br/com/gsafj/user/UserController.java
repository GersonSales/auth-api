package br.com.gsafj.user;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;


  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserModel> getAll() {
    return this.userService.findAll();
  }

  @RequestMapping(
      value = "/{id}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public UserModel getById(@PathVariable final String id) {
    return this.userService.findById(id);
  }

  @RequestMapping(
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public UserModel post(@RequestBody UserModel userModel) {
    return this.userService.create(userModel);
  }


  @RequestMapping(
      value = "/{id}",
      method = RequestMethod.DELETE)
  public void delete(@PathVariable String id) {
    this.userService.remove(id);
  }


}

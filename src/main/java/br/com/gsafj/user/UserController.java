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

  @GetMapping
  public List<UserModel> getAll() {
    return this.userService.findAll();
  }

  @GetMapping("/{id}")
  public UserModel getById(@PathVariable final String id) {
    return this.userService.findById(id);
  }

  @PostMapping
  public UserModel post(@RequestBody UserModel userModel) {
    return this.userService.create(userModel);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable String id) {
    this.userService.remove(id);
  }


}

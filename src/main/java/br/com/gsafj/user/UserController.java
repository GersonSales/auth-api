package br.com.gsafj.user;


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
  public final List<UserVO> getAll() {
    return this.userService.findAll();
  }

  @GetMapping("/{id}")
  public final UserVO getById(@PathVariable final String id) {
    return this.userService.findById(id);
  }

  @PostMapping
  public final UserVO post(@RequestBody UserVO userVO) {
    return this.userService.create(userVO);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable String id) {
    this.userService.remove(id);
  }


}

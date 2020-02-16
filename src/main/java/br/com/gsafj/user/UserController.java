package br.com.gsafj.user;


import br.com.gsafj.contract.RestContract;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.gsafj.config.hateoas.HateoasLinkFactory.linkToGetByIdWithSelfRel;

@RestController
@RequestMapping("/user")
public class UserController implements RestContract {
  private final UserService userService;


  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public final List<UserVO> getAll() {
    return this.userService.findAll();
  }

  @GetMapping("/{id}")
  public final UserVO getById(@PathVariable final Long id) {
    return linkToGetByIdWithSelfRel(
        this.userService.findById(id),
        UserController.class);
  }

  @PostMapping
  public final UserVO post(@RequestBody final UserVO userVO) {
    return this.userService.create(userVO);
  }

  @PutMapping
  public final UserVO put(@RequestBody final UserVO userVO) {
    return this.userService.update(userVO);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Long id) {
    this.userService.remove(id);
  }
}

package br.com.gsafj.user;


import br.com.gsafj.contract.RestContract;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.gsafj.config.hateoas.HateoasLinkFactory.linkAllToRepresentationByIdWithSelfRel;
import static br.com.gsafj.config.hateoas.HateoasLinkFactory.linkToRepresentationByIdWithSelfRel;

@RestController
@RequestMapping("/user")
public class UserController implements RestContract {
  private final UserService userService;


  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public final List<UserVO> getAll() {
    return linkAllToRepresentationByIdWithSelfRel(
        this.userService.findAll(),
        UserController.class
    );
  }

  @GetMapping("/{id}")
  public final UserVO getById(@PathVariable final Long id) {
    return linkToRepresentationByIdWithSelfRel(
        this.userService.findById(id),
        UserController.class);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public final UserVO post(@RequestBody final UserVO userVO) {
    return linkToRepresentationByIdWithSelfRel(
        this.userService.create(userVO),
        UserController.class);
  }

  @PutMapping
  public final UserVO put(@RequestBody final UserVO userVO) {
    return linkToRepresentationByIdWithSelfRel(
        this.userService.update(userVO),
        UserController.class);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Long id) {
    this.userService.remove(id);
  }
}

package br.com.gsafj.config.hateoas;

import br.com.gsafj.contract.RestContract;
import br.com.gsafj.contract.ViewObjectContract;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HateoasLinkFactory {

  public static <T extends RepresentationModel<?> & ViewObjectContract>
  T linkToGetByIdWithSelfRel(
      final T representationModel,
      Class<? extends RestContract> restController) {

    representationModel.add(
        linkTo(
            methodOn(restController).getById(representationModel.getId()))
            .withSelfRel()
    );
    return representationModel;
  }
}

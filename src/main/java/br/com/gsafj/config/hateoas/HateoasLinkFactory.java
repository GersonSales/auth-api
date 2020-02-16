package br.com.gsafj.config.hateoas;

import br.com.gsafj.contract.RestContract;
import br.com.gsafj.contract.ViewObjectContract;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HateoasLinkFactory {

  public static void linkToGetByIdWithSelfRel(
      final RepresentationModel<?> representationModel,
      Class<? extends RestContract> restController,
      ViewObjectContract viewObject) {

    representationModel.add(
        linkTo(
            methodOn(restController).getById(viewObject.getId()))
            .withSelfRel()
    );

  }


}

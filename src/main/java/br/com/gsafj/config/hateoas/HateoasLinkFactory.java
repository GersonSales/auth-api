package br.com.gsafj.config.hateoas;

import br.com.gsafj.contract.RestContract;
import br.com.gsafj.contract.ViewObjectContract;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HateoasLinkFactory {

  public static <T extends RepresentationModel<?> & ViewObjectContract>
  T linkToRepresentationByIdWithSelfRel(
      final T representationModel,
      final Class<? extends RestContract> restController) {

    representationModel.add(
        linkTo(
            methodOn(restController).getById(representationModel.getId()))
            .withSelfRel()
    );
    return representationModel;
  }

  public static <T extends RepresentationModel<?> & ViewObjectContract>
  List<T> linkAllToRepresentationByIdWithSelfRel(
      final List<T> representationModelList,
      final Class<? extends RestContract> restController) {
    representationModelList
        .forEach(viewObject ->
            linkToRepresentationByIdWithSelfRel(viewObject, restController));
    return representationModelList;
  }


}

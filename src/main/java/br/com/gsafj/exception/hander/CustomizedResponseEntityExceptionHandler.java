package br.com.gsafj.exception.hander;

import br.com.gsafj.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(
      final Exception exception,
      final WebRequest request) {

    final ExceptionResponse exceptionResponse
        = getExceptionResponse(exception, request);

    return new ResponseEntity<ExceptionResponse>(exceptionResponse,
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ExceptionResponse getExceptionResponse(final Exception exception,
                                                 final WebRequest request) {
    return new ExceptionResponse(exception.getMessage(),
        request.getDescription(false));
  }


}

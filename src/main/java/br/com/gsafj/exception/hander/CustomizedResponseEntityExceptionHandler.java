package br.com.gsafj.exception.hander;

import br.com.gsafj.exception.ExceptionResponse;
import br.com.gsafj.exception.InvalidJwtAuthenticationException;
import br.com.gsafj.exception.MalformedUserInfoException;
import br.com.gsafj.exception.UserNotFoundException;
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
    final ExceptionResponse response = getExceptionResponse(exception, request);
    return getResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }


  @ExceptionHandler(MalformedUserInfoException.class)
  public final ResponseEntity<ExceptionResponse> handleMalformedUserException(
      final Exception exception,
      final WebRequest request) {
    final ExceptionResponse response = getExceptionResponse(exception, request);
    return getResponseEntity(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(
      final Exception exception,
      final WebRequest request) {
    final ExceptionResponse response = getExceptionResponse(exception, request);
    return getResponseEntity(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidJwtAuthenticationException.class)
  public final ResponseEntity<ExceptionResponse> InvalidJwtAuthenticationException(
      final Exception exception,
      final WebRequest request) {
    final ExceptionResponse response = getExceptionResponse(exception, request);
    return getResponseEntity(response, HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<ExceptionResponse> getResponseEntity(
      final ExceptionResponse response,
      final HttpStatus badRequest) {
    return new ResponseEntity<ExceptionResponse>(response, badRequest);
  }


  private ExceptionResponse getExceptionResponse(final Exception exception,
                                                 final WebRequest request) {
    return new ExceptionResponse(
        exception.getMessage(),
        request.getDescription(false));
  }


}

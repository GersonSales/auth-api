package br.com.gsafj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedUserInfoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public MalformedUserInfoException() {
    super("Malformed user Info.");
  }
}

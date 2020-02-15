package br.com.gsafj.exception;

import java.io.Serializable;

public class MalformedUserInfoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public MalformedUserInfoException() {
    super("Malformed user Info.");
  }
}

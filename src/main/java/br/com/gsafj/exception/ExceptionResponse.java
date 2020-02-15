package br.com.gsafj.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Date timestamp;
  private String message;
  private String description;

  public ExceptionResponse(final String message, final String description) {
    this.timestamp = new Date();
    this.message = message;
    this.description = description;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }
}

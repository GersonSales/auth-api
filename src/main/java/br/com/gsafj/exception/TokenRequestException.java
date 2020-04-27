package br.com.gsafj.exception;

public class TokenRequestException extends RuntimeException{

  private static final long serialVersionUID = 2497996709789784195L;

  public TokenRequestException() {
    super("Token request error.");
  }

  public TokenRequestException(String message) {
    super(message);
  }
}

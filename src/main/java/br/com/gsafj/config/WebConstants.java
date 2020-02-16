package br.com.gsafj.config;

import org.springframework.http.MediaType;

public class WebConstants {
  public static final String JSON_EXTENSION = "json";
  public static final String XML_EXTENSION = "xml";
  public static final String MEDIA_TYPE_TAG = "mediaType";

  public static final String APPLICATION_X_YAML = "application/x-yaml";
  public static final String APPLICATION_XML = "application/xml";
  public static final String APPLICATION_JSON = "application/json";

  public static final MediaType YAML_MEDIA_TYPE
      = MediaType.valueOf(APPLICATION_X_YAML);


  public static final String GET = "GET";
  public static final String POST = "POST";
  public static final String PUT = "PUT";
  public static final String DELETE = "DELETE";
  public static final String PATCH = "PATCH";
  public static final String OPTIONS = "OPTIONS";
  public static final String TRACE = "TRACE";

}

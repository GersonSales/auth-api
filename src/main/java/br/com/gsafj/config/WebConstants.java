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
}

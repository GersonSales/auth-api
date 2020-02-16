package br.com.gsafj.config.converter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import static br.com.gsafj.config.WebConstants.APPLICATION_X_YAML;

public class YamlJackson2HttpMessageConverter
    extends AbstractJackson2HttpMessageConverter {

  public YamlJackson2HttpMessageConverter() {
    super(new YAMLMapper(), MediaType.parseMediaType(APPLICATION_X_YAML));
  }
}

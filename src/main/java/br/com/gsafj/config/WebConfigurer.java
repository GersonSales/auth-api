package br.com.gsafj.config;


import br.com.gsafj.config.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static br.com.gsafj.config.WebConstants.*;


@Configuration
@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer {

  @Override
  public void extendMessageConverters(
      final List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlJackson2HttpMessageConverter());

  }

  @Override
  public void configureContentNegotiation(
      final ContentNegotiationConfigurer configurer) {
    configurer
        .favorPathExtension(false)
        .favorParameter(false)
//        .parameterName(MEDIA_TYPE_TAG)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_XML)
        .mediaType(JSON_EXTENSION, MediaType.APPLICATION_JSON)
        .mediaType(JSON_EXTENSION, YAML_MEDIA_TYPE)
        .mediaType(XML_EXTENSION, MediaType.APPLICATION_XML);


  }
}

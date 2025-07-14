package com.rubensgomes.useraccount.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * A helper class to be shared among IT web controller tests. It provides several utilities (e.g.,
 * HttpHeaders, TestRestTemplate) to be used during web controller integration tests.
 *
 * @author Rubens Gomes
 */
@Slf4j
abstract class BaseIntegration {
  protected static final String BASE_URL = "http://localhost:";

  protected final TestRestTemplate testRestTemplate;
  protected final HttpHeaders httpHeaders;

  protected BaseIntegration() {
    var medias = new ArrayList<MediaType>();
    medias.add(MediaType.APPLICATION_JSON);

    this.httpHeaders = new HttpHeaders();
    this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    this.httpHeaders.setAccept(medias);

    var messageConverter = new MappingJackson2HttpMessageConverter(new ObjectMapper());
    var templateBuilder = new RestTemplateBuilder();
    templateBuilder.additionalMessageConverters(messageConverter);

    this.testRestTemplate = new TestRestTemplate(templateBuilder);
    log.trace("constructed");
  }
}

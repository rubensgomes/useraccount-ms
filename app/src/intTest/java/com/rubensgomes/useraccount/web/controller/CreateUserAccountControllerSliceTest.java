package com.rubensgomes.useraccount.web.controller;

import static com.rubensgomes.useraccount.web.controller.CreateUserAccountController.CREATE_USER_ACCOUNT_OPERATION;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubensgomes.useraccount.model.CreateUserAccountRequest;
import com.rubensgomes.useraccount.model.Status;
import com.rubensgomes.useraccount.model.StatusResponse;
import com.rubensgomes.useraccount.service.CreateUserAccountService;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Slf4j
@ActiveProfiles("test")
@WebMvcTest(controllers = {CreateUserAccountController.class})
class CreateUserAccountControllerSliceTest extends BaseIntegration {

  private final ObjectMapper mapper = new ObjectMapper();
  @LocalServerPort private String localPort;
  @Autowired private MockMvc mockMvc;
  @MockitoBean private CreateUserAccountService service;

  @Test
  void failDueToInvalidEmail() throws Exception {
    val request = new CreateUserAccountRequest("vasco", "testing");
    val jsonRequest = mapper.writeValueAsString(request);

    URI uri = new URI("http://localhost:" + this.localPort + CREATE_USER_ACCOUNT_OPERATION);

    var servletResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    log.info("errorMessage: {}", servletResponse.getErrorMessage());
    assertEquals(HttpStatus.BAD_REQUEST.value(), servletResponse.getStatus());
  }

  @Test
  void failDueToBlankPassword() throws Exception {
    val request = new CreateUserAccountRequest("vasco@vasco.com", "");
    val response = new StatusResponse(Status.SUCCESS, "created");
    Mockito.doReturn(response).when(service).createUserAccount(request.email(), request.password());

    val jsonRequest = mapper.writeValueAsString(request);

    URI uri = new URI("http://localhost:" + this.localPort + CREATE_USER_ACCOUNT_OPERATION);

    var servletResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    log.info("errorMessage: {}", servletResponse.getErrorMessage());
    assertEquals(HttpStatus.BAD_REQUEST.value(), servletResponse.getStatus());
  }

  @Test
  void succeedCreateUserAccount() throws Exception {
    val request = new CreateUserAccountRequest("vasco@vasco.com", "testing");
    val response = new StatusResponse(Status.SUCCESS, "created");
    Mockito.doReturn(response).when(service).createUserAccount(request.email(), request.password());

    val jsonRequest = mapper.writeValueAsString(request);
    URI uri = new URI("http://localhost:" + this.localPort + CREATE_USER_ACCOUNT_OPERATION);

    var servletResponse =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    log.info("content: {}", servletResponse.getContentAsString());
    assertEquals(HttpStatus.OK.value(), servletResponse.getStatus());
  }
}

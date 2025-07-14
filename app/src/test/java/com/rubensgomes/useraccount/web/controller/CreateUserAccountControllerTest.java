package com.rubensgomes.useraccount.web.controller;

import com.rubensgomes.useraccount.model.CreateUserAccountRequest;
import com.rubensgomes.useraccount.service.CreateUserAccountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateUserAccountControllerTest {

    @Test
    void ensureCreateUserAccountResponds() {
        var service = new CreateUserAccountService();
        var controller = new CreateUserAccountController(service);
        var request = new CreateUserAccountRequest("test@test.com", "testing");
        var response = controller.createUserAccount(request);
        assertNotNull(response);
    }

}
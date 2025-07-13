package com.rubensgomes.useraccount.web.controller;

import com.rubensgomes.useraccount.model.CreateUserAccountRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateUserAccountControllerTest {

    @Test
    void ensureCreateUserAccountResponds() {
        var controller = new CreateUserAccountController();
        var request = new CreateUserAccountRequest("test@test.com", "testing");
        var response = controller.createUserAccount(request);
        assertNotNull(response);
    }

}
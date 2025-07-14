package com.rubensgomes.useraccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserAccountApplicationTest {

    @Test
    void ensureConstructorCreated() {
        var app = new UserAccountApplication();
        assertNotNull(app);
    }
}

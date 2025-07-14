package com.rubensgomes.useraccount;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * A Spring Boot test class to ensure Spring container starts.
 *
 * @author Rubens Gomes
 */
@ActiveProfiles("test")
@SpringBootTest
class UserAccountApplicationIT {

  @Test
  void ensureSpringContainerStarts() {
    // to ensure container is up and running...
    assertTrue(true);
  }
}

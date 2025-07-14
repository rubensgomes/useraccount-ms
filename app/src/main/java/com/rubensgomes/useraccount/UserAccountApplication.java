package com.rubensgomes.useraccount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Spring Boot Application class.
 *
 * @author Rubens Gomes
 */
@Slf4j
@SpringBootApplication
class UserAccountApplication {

    /**
     * Default constructor for the App class.
     */
    public UserAccountApplication() {
        // Default constructor
    }

    /**
     * Spring Application bootstrap main method.
     *
     * @param args a null or array of {@link String} arguments.
     */
    public static void main( String[] args )
    {
        log.debug( "Starting [{}] application with args [{}]",
                UserAccountApplication.class.getName(),
                args );
        SpringApplication.run( UserAccountApplication.class, args );
    }
}

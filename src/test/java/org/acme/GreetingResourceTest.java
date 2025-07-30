package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Nested
    class X {

        @Test
        void get() {
            given()
                    .when().get("/hello/x/subpath")
                    .then()
                    .statusCode(200)
                    .body(is("x"));
        }

        @Test
        void head() {
            given()
                    .when().head("/hello/x/subpath")
                    .then()
                    .statusCode(200);
        }
    }

    @Nested
    class Y {

        @Test
        void get() {
            given()
                    .when().get("/hello/y/subpath")
                    .then()
                    .statusCode(200)
                    .body(is("y"));
        }

        @Test
        void head() {
            given()
                    .when().head("/hello/y/subpath")
                    .then()
                    .statusCode(200);
            // -> unexpected 405
        }
    }


}
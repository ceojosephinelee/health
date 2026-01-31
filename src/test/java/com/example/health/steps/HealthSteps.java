package com.example.health.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthSteps {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("클라이언트가 GET \\/health API를 요청하면")
    public void 클라이언트가_health_api를_요청하면() {
        String url = "http://localhost:" + port + "/health";
        response = restTemplate.getForEntity(url, String.class);
    }

    @Then("응답 상태 코드는 {int} 이어야 한다")
    public void 응답_상태_코드는_이어야_한다(int statusCode) {
        assertThat(response.getStatusCode().value()).isEqualTo(statusCode);
    }

    @Then("응답 본문은 {string} 이어야 한다")
    public void 응답_본문은_이어야_한다(String expectedBody) {
        assertThat(response.getBody()).isEqualTo(expectedBody);
    }
}

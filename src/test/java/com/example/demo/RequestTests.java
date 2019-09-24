package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RequestTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void isOlTests() {
        this.webClient.get().uri("/").exchange().expectStatus().isOk();
        this.webClient.get().uri("/main").exchange().expectStatus().isOk();
        this.webClient.get().uri("/error").exchange().expectStatus().isOk();
        this.webClient.get().uri("/login").exchange().expectStatus().isOk();
        this.webClient.get().uri("/result").exchange().expectStatus().isOk();
    }

    @Test
    public void mainTest() {
        assertThat(true).isTrue();
    }

    @Test
    public void mainPageTest() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Form");
    }
    @Test
    public void mainPageWaysToGetPage(){
        String mainBody = this.restTemplate.getForObject("/main", String.class);
        String slashBody = this.restTemplate.getForObject("/", String.class);
        assertThat(mainBody).isEqualTo(slashBody);
    }

    @Test
    public void errorPageContainCodeTest() {
        String body = this.restTemplate.getForObject("/error", String.class);
        assertThat(body).contains("Error Page");
        assertThat(body).contains("Status code: <b>null</b>");
        assertThat(body).contains("Exception Message: <b>N/A</b>");
    }
    @Test
    public void errorPageDoesNotContainTest() {
        String body = this.restTemplate.getForObject("/error", String.class);
        assertThat(body).doesNotContain("Hello world!");
        assertThat(body).doesNotContain("Form!");
    }


}

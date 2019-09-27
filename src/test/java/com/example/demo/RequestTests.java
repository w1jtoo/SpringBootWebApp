package com.example.demo;


import com.example.demo.logic.PizzaName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RequestTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebTestClient webClient;

    public void setUp(){
        // default user name
        this.webClient.get().uri("/login?name=Test");
    }

    @Test
    public void isOkTests() {
        this.webClient.get().uri("/error").exchange().expectStatus().isOk();
        this.webClient.get().uri("/login").exchange().expectStatus().isOk();
        this.webClient.get().uri("/result").exchange().expectStatus().isOk();
    }

    @Test
    public void mainTest() {
        assertThat(true).isTrue();
    }
    private PizzaName getRandomPizza(){
        var random = new Random();
        var size = PizzaName.values().length;
        return PizzaName.values()[random.nextInt(size)];
    }
    @Test
    public void addingRealPizzaTest() {
        var pizza = getRandomPizza();
        String body = this.restTemplate.getForObject("/addorder?name=" + pizza.toString(), String.class);
        assertThat(body).isEqualTo(pizza.toString());
    }

    @Test
    public void addingNonexistentPizzaTest() {
        var pizzaName = getRandomPizza().toString() + "1"; //wrong name
        String body = this.restTemplate.getForObject("/addorder?name=" + pizzaName,
                String.class);
        assertThat(body).isEqualTo("No enum constant com.example.demo.logic.PizzaName."
                + pizzaName);
    }

    @Test
    public void removeRightPizza(){
        var pizzaName = PizzaName.Chicago.toString();
        this.restTemplate.getForObject("/addorder?name=" + pizzaName, String.class);
        var body = this.restTemplate
                .getForObject("/delorder?name=" + pizzaName, String.class);
        assertThat(body).isEqualTo(pizzaName);
    }

    @Test
    public void removeWithWrongPizzaName(){
        var pizzaName1 = PizzaName.Chicago.toString();
        var pizzaName2 = "Shicago12";
        this.restTemplate.getForObject("/addorder?name=" + pizzaName1, String.class);
        var body = this.restTemplate
                .getForObject("/delorder?name=" + pizzaName2, String.class);
        assertThat(body).isEqualTo("No enum constant com.example.demo.logic.PizzaName." + pizzaName2);
    }

    // TODO result test ? 

    @Test
    public void removeNonexistentPizza(){
        var pizzaName = PizzaName.Chicago.toString();
        var body = this.restTemplate
                .getForObject("/delorder?name=" + pizzaName, String.class);
        assertThat(body).isEqualTo("0");
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

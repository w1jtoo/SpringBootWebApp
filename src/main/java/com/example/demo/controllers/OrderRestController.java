package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.Order;
import com.example.demo.logic.PizzaName;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @GetMapping()
    public Order addOrder() throws Exception{
        return InfoContainer.getOrder();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postOrder(@Valid @RequestBody PizzaName pizza) {
        InfoContainer.getOrder().addCourse(pizza);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + pizza.toString())
                        .build()
                        .toUri())
                .build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity delOrder(@PathVariable("name") String name) {
        var pizza = PizzaName.valueOf(name);
        try {
            InfoContainer.getOrder().delCourse(pizza);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
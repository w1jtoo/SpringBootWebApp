package com.example.demo;


import com.example.demo.logic.InfoContainer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainLogicTests {

    @Test
    public void ContainerFieldsTest(){
        var infoContainer = new InfoContainer();
        assertThat(infoContainer).hasFieldOrProperty("user");
    }
}

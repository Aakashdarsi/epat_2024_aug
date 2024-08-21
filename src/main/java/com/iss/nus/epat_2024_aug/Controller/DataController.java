package com.iss.nus.epat_2024_aug.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DataController {

    @GetMapping("/")

    public String healthCheck(){
        return "Health is OK";
    }

    @GetMapping("/version")

    public String getVersion(){
        return "Your Current version is 1.0";
    }

    @GetMapping("/nations")

    public JsonNode getNations(){
        ObjectMapper objectMapper = new ObjectMapper();
        Faker faker = new Faker();
        var arrayNode = objectMapper.createArrayNode();
        for(var i = 0; i < 10 ; i++){
            var nation = faker.nation();
            arrayNode.add(objectMapper.createObjectNode().put("natiionality",nation.nationality())
                    .put("capital city", nation.capitalCity())
                    .put("falg", nation.flag())
                    .put("language",nation.language()));

        }
        return arrayNode;
    }


}

package com.iss.nus.epat_2024_aug;

import com.iss.nus.epat_2024_aug.Controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DataControllerTest {
    @Autowired
    DataController dataController;

    @Test
    void healthCheck(){
        assertEquals("Health is OK",dataController.healthCheck());
    }

    @Test
    void versions(){
        assertEquals("Your Current version is 1.0",dataController.getVersion());
    }

    @Test
    void nationsLength(){
        Integer nationsLength = dataController.getNations().size();
        assertEquals(10,nationsLength);
    }


}

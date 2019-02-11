package com.factorial.calcFactorialTrailing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static com.factorial.calcFactorialTrailing.service.FactorialService.*;
import static com.factorial.calcFactorialTrailing.utils.ErrorMaps.*;

@RestController
public class FactorialController {

    @GetMapping(value="factorialTrail/{number}", produces = "application/json")
    public Map getTrail(@PathVariable String number){
        try{
            Long longNumber = Long.parseLong(number);
            if (longNumber >= 0)
                return Collections.singletonMap("response", getFactorialTrail(Long.parseLong(number)).toString());
            else
                return NEGATIVE_ERROR;
        }
        catch(NumberFormatException e){
            return INCORRECT_FORMAT_ERROR;
        }
    }
}


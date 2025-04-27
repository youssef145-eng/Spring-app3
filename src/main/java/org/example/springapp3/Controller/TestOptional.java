package org.example.springapp3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestOptional {
    @GetMapping("test-optional")
    public void  TestOptional() {

        Integer X=null;
        Optional<Integer> Y= Optional.ofNullable(X);
        if(Y.isPresent()) {
            System.out.println("Y is present");
        }
        else
            System.out.println("Y is absent");
        System.out.println("test-optional");

       ;
    }

}

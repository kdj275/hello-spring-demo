package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Create a form to display form at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    //createMessage controller takes in a name and language string;
    //user submits the form (via a POST request)
    // displays proper greeting based on language string
    @RequestMapping(value="hello", method= RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            greeting = "Hello";
        }
        else if (language.equals("spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("german")) {
            greeting = "Hallo";
        }
        else if (language.equals("italian")) {
            greeting = "Ciao";
        }
        return greeting + ", " + name + "!";
//          link to go back to form page needs an event listener
//                "<br>" +
//                "<a href='localhost:8080/hello/form'>Go Back to Form</a>";
    }
}

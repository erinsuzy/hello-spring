package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //handles request at path /hello
    //@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
       return "Goodbye, Spring!";
    }

    //Handles request of the form /hello/name=LaunchCode
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
       return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
       return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        String html = "<html>" +
                "<body>" +
                "<form action= 'hello' method= 'post'>" + //submit a request to /hello
                "<input type = 'text' name= name>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

    /*@RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }

     */
}


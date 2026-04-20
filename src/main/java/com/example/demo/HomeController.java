package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("name") String name,
                                      @RequestParam("file") MultipartFile file) {

        Map<String, Object> result = new HashMap<>();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fileName = file.getOriginalFilename().toLowerCase();

        String skills;
        int score;
        String missing;
        String suggestion;

        if (fileName.contains("java")) {
            skills = "Java, Spring Boot, HTML";
            score = 85;
            missing = "AWS, Docker";
            suggestion = "Add cloud and DevOps skills";
        } else {
            skills = "Basic Skills";
            score = 60;
            missing = "Advanced Tech Skills";
            suggestion = "Improve projects and add certifications";
        }

        result.put("score", score);
        result.put("skills", skills);
        result.put("missing", missing);
        result.put("suggestion", suggestion);

        return result;
    }
}
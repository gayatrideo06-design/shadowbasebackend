package org.example.shadowbasebackend.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Backend Working!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())) {
            return "Login Successful";
        }

        return "Invalid Username or Password";
    }

    @GetMapping("/start")
    public String start() {
        return "Shadow DB Started!";
    }

    @GetMapping("/stop")
    public String stop() {
        return "Shadow DB Stopped!";
    }
}
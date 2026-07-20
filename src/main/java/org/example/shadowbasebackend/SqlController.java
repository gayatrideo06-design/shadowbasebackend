package org.example.shadowbasebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sql")
@CrossOrigin(origins = "http://localhost:5173")
public class SqlController {

    @Autowired
    private SqlService sqlService;

    @PostMapping("/execute")
    public Object execute(@RequestBody SqlRequest request) {
        return sqlService.execute(request.getSql());
    }
}
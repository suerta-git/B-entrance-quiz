package com.thoughtworks.capability.gtb.entrancequiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO GTB-工程实践: - 与业务需求无关的代码及时清理
@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class ConnectionTestController {
    @GetMapping("/connection-test")
    public ResponseEntity<Void> testConnection() {
        return ResponseEntity.ok().build();
    }
}

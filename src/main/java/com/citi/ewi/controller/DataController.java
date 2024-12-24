package com.citi.ewi.controller;

import com.citi.ewi.model.DataModel;
import com.citi.ewi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public ResponseEntity<String> sendData(@RequestBody DataModel data) {
        dataService.sendMessage(data);
        return ResponseEntity.ok("Data sent to Kafka");
    }

}

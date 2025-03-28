package com.dndats.transaction_api.controller;

import com.dndats.transaction_api.dto.StatisticsResponseDTO;
import com.dndats.transaction_api.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponseDTO> getStatistics(
            @RequestParam(value="intervalo", required = false, defaultValue = "60")
            Integer searchInterval) {
        return ResponseEntity.ok(service.getStatistics(searchInterval));
    }

}

package com.dndats.transaction_api.controller;

import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody TransactionRequestDTO dto) {
        service.addTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

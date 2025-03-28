package com.dndats.transaction_api.controller;

import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        service.deleteAllTransactions();
        return ResponseEntity.ok().build();
    }

}

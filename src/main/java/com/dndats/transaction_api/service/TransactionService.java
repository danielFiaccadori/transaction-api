package com.dndats.transaction_api.service;

import com.dndats.transaction_api.data.TransactionRepositoryImpl;
import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.exceptions.UnprocessableEntity;
import com.dndats.transaction_api.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransactionService {

    private final TransactionRepositoryImpl repository;
    private final TransactionMapper mapper;

    public TransactionService(TransactionRepositoryImpl repository, TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addTransaction(TransactionRequestDTO dto) {
        if (dto.value() == null || dto.timestamp() == null) {
            throw new UnprocessableEntity("Value must be provided");
        }
        if (dto.timestamp().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity("Timestamp must be in the past");
        }
        if (dto.value() < 0) {
            throw new UnprocessableEntity("Value must be positive");
        }

        repository.save(mapper.toTransactionFromDto(dto));
    }

    public void deleteAllTransactions() {
        repository.deleteAll();
    }

}

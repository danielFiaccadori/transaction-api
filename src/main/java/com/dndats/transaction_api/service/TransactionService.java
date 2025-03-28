package com.dndats.transaction_api.service;

import com.dndats.transaction_api.data.TransactionRepository;
import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.exceptions.UnprocessableEntity;
import com.dndats.transaction_api.mapper.TransactionMapper;
import com.dndats.transaction_api.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public TransactionService(TransactionRepository repository, TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addTransaction(TransactionRequestDTO dto) {
//        log.info("Processing transaction...");
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
//        log.info("Transaction processed successfully");
    }

    public void deleteAllTransactions() {
        repository.deleteAll();
//        log.info("All transactions deleted");
    }

    public List<TransactionRequestDTO> findAllTransactions(Integer searchInterval) {
        List<Transaction> transactions = repository.findAll(searchInterval);
        return mapper.toTransactionRequestDTOList(transactions);
    }

}

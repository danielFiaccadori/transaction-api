package com.dndats.transaction_api.mapper;

import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionMapper() {
    }

    public Transaction toTransactionFromDto(TransactionRequestDTO transactionRequestDTO) {
        return new Transaction(transactionRequestDTO.value(), transactionRequestDTO.timestamp());
    }
}

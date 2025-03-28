package com.dndats.transaction_api.mapper;

import com.dndats.transaction_api.dto.TransactionRequestDTO;
import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionMapper {

    public TransactionMapper() {
    }

    public Transaction toTransactionFromDto(TransactionRequestDTO transactionRequestDTO) {
        return new Transaction(transactionRequestDTO.value(), transactionRequestDTO.timestamp());
    }

    public TransactionRequestDTO toDTOFromTransaction(Transaction transaction) {
        return new TransactionRequestDTO(transaction.getValue(), transaction.getTimestamp());
    }

    public List<TransactionRequestDTO> toTransactionRequestDTOList(List<Transaction> transactions) {
        return transactions.stream().map(this::toDTOFromTransaction).toList();
    }

}

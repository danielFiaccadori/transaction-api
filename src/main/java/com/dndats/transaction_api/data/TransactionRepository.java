package com.dndats.transaction_api.data;

import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository implements CustomRepository<Transaction> {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(Transaction entity) {
        transactions.add(entity);
    }

    @Override
    public void deleteAll() {
        transactions.clear();
    }

    @Override
    public List<Transaction> findAll(Integer searchInterval) {
        return transactions.stream()
                .filter(transaction -> transaction.getTimestamp()
                        .isAfter(transaction.getTimestamp().minusSeconds(searchInterval))).toList();
    }

}

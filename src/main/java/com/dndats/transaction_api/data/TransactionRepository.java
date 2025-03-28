package com.dndats.transaction_api.data;

import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository implements CustomRepository<Transaction> {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction save(Transaction entity) {
        return null;
    }

}

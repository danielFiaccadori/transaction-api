package com.dndats.transaction_api.data;

import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository<Transaction> {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(Transaction entity) {
        transactions.add(entity);
    }

    @Override
    public boolean deleteAll() {
        transactions.clear();
        return true;
    }

}

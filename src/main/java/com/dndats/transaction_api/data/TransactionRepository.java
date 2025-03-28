package com.dndats.transaction_api.data;

import org.springframework.stereotype.Component;

@Component
public interface TransactionRepository<T> {

    void save(T entity);
    boolean deleteAll();

}

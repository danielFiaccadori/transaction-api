package com.dndats.transaction_api.data;

import com.dndats.transaction_api.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This interface is used to define the methods that will be implemented by other repositories.
 * @param <T>
 */

@Component
public interface CustomRepository<T> {

    void save(T entity);
    void deleteAll();
    List<Transaction> findAll(Integer searchInterval);

}

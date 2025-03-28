package com.dndats.transaction_api.data;

import org.springframework.stereotype.Component;

@Component
public interface CustomRepository<T> {

    T save(T entity);

}

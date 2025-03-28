package com.dndats.transaction_api.model;

import java.time.OffsetDateTime;

public class Transaction {

    private final Double value;
    private final OffsetDateTime timestamp;

    public Transaction(Double value, OffsetDateTime timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

}

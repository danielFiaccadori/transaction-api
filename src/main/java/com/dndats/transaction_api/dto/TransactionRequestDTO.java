package com.dndats.transaction_api.dto;

import java.time.OffsetDateTime;

public record TransactionRequestDTO(Double value, OffsetDateTime timestamp) {
}

package com.dndats.transaction_api.dto;

public record StatisticsResponseDTO(Long count, Double sum, Double avg, Double max, Double min) {
}

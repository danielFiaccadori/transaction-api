package com.dndats.transaction_api.service;

import com.dndats.transaction_api.dto.StatisticsResponseDTO;
import com.dndats.transaction_api.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class StatisticsService {

    private final TransactionService transactionService;

    public StatisticsService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticsResponseDTO getStatistics(Integer searchInterval) {
        List<TransactionRequestDTO> transactions = transactionService.findAllTransactions(searchInterval);
        DoubleSummaryStatistics statistics = transactions.stream().mapToDouble(TransactionRequestDTO::value).summaryStatistics();

        if (statistics.getCount() == 0) {
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new StatisticsResponseDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin()
        );
    }

}

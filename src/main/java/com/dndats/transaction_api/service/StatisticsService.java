package com.dndats.transaction_api.service;

import com.dndats.transaction_api.dto.StatisticsResponseDTO;
import com.dndats.transaction_api.dto.TransactionRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class StatisticsService {

    // Logger needed to be manually created due to IntelliJ annotation processing issues
    private static final Logger log = LoggerFactory.getLogger(StatisticsService.class);

    private final TransactionService transactionService;

    public StatisticsService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticsResponseDTO getStatistics(Integer searchInterval) {
        log.info("Calculating statistics...");
        List<TransactionRequestDTO> transactions = transactionService.findAllTransactions(searchInterval);
        DoubleSummaryStatistics statistics = transactions.stream().mapToDouble(TransactionRequestDTO::value).summaryStatistics();

        if (statistics.getCount() == 0) {
            log.info("No transactions found");
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        log.info("Statistics calculated successfully");
        return new StatisticsResponseDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin()
        );
    }

}

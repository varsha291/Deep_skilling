package com.library.ormlearn;

import com.library.ormlearn.model.Stock;
import com.library.ormlearn.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static StockService stockService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        stockService = context.getBean(StockService.class);

        testStockQueries();
    }

    private static void testStockQueries() {

        LOGGER.info("===== META Stocks Between Dates =====");

        List<Stock> stocks = stockService.getStocksBetweenDates(
                "META",
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 3));

        stocks.forEach(stock -> LOGGER.info("{}", stock));

        LOGGER.info("===== GOOG Price > 143 =====");

        stockService.getStocksAbovePrice("GOOG", 143)
                .forEach(stock -> LOGGER.info("{}", stock));

        LOGGER.info("===== Top 3 Volume =====");

        stockService.getTop3ByVolume()
                .forEach(stock -> LOGGER.info("{}", stock));

        LOGGER.info("===== Lowest 3 Netflix Closing Prices =====");

        stockService.getLowest3ClosingPrices("NFLX")
                .forEach(stock -> LOGGER.info("{}", stock));
    }
}
package com.library.ormlearn.service;

import com.library.ormlearn.model.Stock;
import com.library.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getStocksBetweenDates(String code, LocalDate startDate, LocalDate endDate) {
        return stockRepository.findByCodeAndDateBetween(code, startDate, endDate);
    }

    @Transactional
    public List<Stock> getStocksAbovePrice(String code, double price) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, price);
    }

    @Transactional
    public List<Stock> getTop3ByVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getLowest3ClosingPrices(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}

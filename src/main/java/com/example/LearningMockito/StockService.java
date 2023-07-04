package com.example.LearningMockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StocksRepository stocksRepository;

    public double getPrice(Stock stock) {
        return stock.getPrice();
    }

}
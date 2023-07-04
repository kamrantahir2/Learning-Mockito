package com.example.LearningMockito.StockPortfolio;

import org.springframework.stereotype.Service;

@Service
public interface StockService {
    public double getPrice(Stock stock);
}
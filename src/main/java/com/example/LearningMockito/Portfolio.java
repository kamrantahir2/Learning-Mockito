package com.example.LearningMockito;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Portfolio {
    private List<Stock> stocksList;
    private double marketValue;

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    private StockService stockService;

    public Portfolio() {
    }


    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue() {
        float sum = 0;
        for (Stock stock : stocksList) {
            sum += (stock.getPrice() * stock.getQuantity());
        }
            this.marketValue = sum;
    }



    public Portfolio(List<Stock> stocksList) {
        this.stocksList = stocksList;
    }

    public List<Stock> getStocksList() {
        return stocksList;
    }

    public void setStocksList(List<Stock> stocksList) {
        this.stocksList = stocksList;
    }
}
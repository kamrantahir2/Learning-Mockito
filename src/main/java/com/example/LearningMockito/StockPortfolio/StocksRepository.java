package com.example.LearningMockito.StockPortfolio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends CrudRepository<Stock, String> {
}

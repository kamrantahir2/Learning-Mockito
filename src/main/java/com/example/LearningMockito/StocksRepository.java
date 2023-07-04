package com.example.LearningMockito;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends CrudRepository<Stocks, String> {
}

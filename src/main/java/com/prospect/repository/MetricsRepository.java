package com.prospect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prospect.model.Metrics;

@Repository
public interface MetricsRepository extends MongoRepository<Metrics, String> {
	
}
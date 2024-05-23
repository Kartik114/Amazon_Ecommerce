package com.example.demo.Repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.Models.Orders;
@EnableMongoRepositories
public interface OrderRepo extends MongoRepository<Orders, ObjectId>{
	public Orders findOrderByUserId(String userId);
	public void deleteByUserId(String userId);
}

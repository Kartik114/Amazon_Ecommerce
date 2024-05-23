package com.example.demo.Repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.dmo.CartItem;
import com.example.demo.models.Cart;


@EnableMongoRepositories
public interface CartRepo extends MongoRepository<Cart,ObjectId > {
	
	List<Cart> findByUserId(String userId);

	void deleteByUserId(String userId);
}

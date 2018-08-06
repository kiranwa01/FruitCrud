package com.example.fruit.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.fruit.model.Fruit;

public interface FruitRepo extends CrudRepository<Fruit, Integer>{

}

package com.example.fruit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.fruit.dao.FruitRepo;
import com.example.fruit.model.Fruit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitCrudApplicationTests {

	@Autowired
	FruitRepo repo;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void checkFruitCount() {
		assertEquals(4, repo.count());
	}
	
	@Test
	public void testAddFruit() {
		Fruit fruit = new Fruit();
		fruit.setId(5);
		fruit.setName("Mango");
		fruit.setSeason("Summer");
		fruit.setShape("Oval");
		fruit.setTaste("Sweet");
		repo.save(fruit);
		assertEquals(5, repo.count());
	}
	
	@Test
	public void testEditFruit() {
		Fruit fruit = repo.findById(5).orElse(new Fruit());
		fruit.setName("Mango");
		fruit.setSeason("Winter");
		fruit.setShape("Round");
		fruit.setTaste("Sweet");
		repo.save(fruit);
		Fruit fruitTwo = repo.findById(5).orElse(new Fruit());
		assertNotEquals(fruitTwo.getSeason(), "Summer", "Winter");
		assertEquals(5, repo.count());
	}
	
	/*@Test
	public void testDeleteFruit() {
		Fruit fruit = new Fruit(8,"Orange");
		repo.save(fruit);
		try {
			repo.wait(1000);
		} catch (InterruptedException e) {
			
		}
		repo.deleteById(8);
		assertEquals(4, repo.count());
	}*/

}

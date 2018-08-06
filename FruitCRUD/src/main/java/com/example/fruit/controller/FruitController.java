package com.example.fruit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.fruit.dao.FruitRepo;
import com.example.fruit.model.Fruit;

@Controller
public class FruitController {

	private static final Logger LOGGER = LogManager.getLogger(FruitController.class);

	
	@Autowired
	FruitRepo repo;

	@RequestMapping("/")
	public ModelAndView home() {
		LOGGER.info("Entered to Home");
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Fruit> listFruits = (List<Fruit>) repo.findAll();
			// List<Fruit> fruits = repo.findAll().orElse(new ArrayList<>());
			modelAndView.addObject("listFruits", listFruits);
			modelAndView.setViewName("home.jsp");
		}catch(Exception e) {
			LOGGER.error("Exception occured in home", e);
			modelAndView.setViewName("error.jsp");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/newFruit", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Fruit fruit = new Fruit();
		model.addObject("fruit", fruit);
		model.setViewName("displayFruit.jsp");
		return model;
	}

	@RequestMapping(value = "/addFruit", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Fruit fruit) {
		repo.save(fruit);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editFruit", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int fruitId = Integer.parseInt(request.getParameter("id"));
		Fruit fruit = repo.findById(fruitId).orElse(new Fruit());
		ModelAndView model = new ModelAndView("displayFruit.jsp");
		model.addObject("fruit", fruit);
		return model;
	}

	@RequestMapping(value = "/getFruit", method = RequestMethod.GET)
	public ModelAndView getFruit(@RequestParam Integer id) {
		ModelAndView modelAndView = new ModelAndView("displayFruit.jsp");
		Fruit fruit = repo.findById(id).orElse(new Fruit());
		modelAndView.addObject(fruit);
		return modelAndView;
	}

	@RequestMapping(value = "/deleteFruit", method = RequestMethod.GET)
	public ModelAndView deleteFruit(HttpServletRequest request) {
		int fruitId = Integer.parseInt(request.getParameter("id"));
		repo.deleteById(fruitId);
		return new ModelAndView("redirect:/");
	}

}

package com.shikbetumio.foodcatelogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shikbetumio.foodcatelogue.dto.FoodCataloguePage;
import com.shikbetumio.foodcatelogue.dto.FoodItemDTO;
import com.shikbetumio.foodcatelogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {

	@Autowired
	FoodCatalogueService foodCatalogueService;

	@PostMapping("/foodItems")
	public ResponseEntity<FoodItemDTO> createFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		FoodItemDTO foodItemAdded = foodCatalogueService.createFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemAdded, HttpStatus.CREATED);
	}

	@GetMapping("/foodCataloguePage/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> getCataloguePage(@PathVariable Integer restaurantId) {
		FoodCataloguePage foodCataloguePage = foodCatalogueService.getCataloguePage(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}
}

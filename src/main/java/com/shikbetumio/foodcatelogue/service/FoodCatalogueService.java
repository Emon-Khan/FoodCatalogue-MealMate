package com.shikbetumio.foodcatelogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shikbetumio.foodcatelogue.dto.FoodCataloguePage;
import com.shikbetumio.foodcatelogue.dto.FoodItemDTO;
import com.shikbetumio.foodcatelogue.dto.Restaurant;
import com.shikbetumio.foodcatelogue.entity.FoodItem;
import com.shikbetumio.foodcatelogue.mapper.FoodItemMapper;
import com.shikbetumio.foodcatelogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	@Autowired
	FoodItemRepo foodItemRepo;

	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO createFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem savedFoodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(savedFoodItem);
	}

	public FoodCataloguePage getCataloguePage(Integer restaurantId) {
		List<FoodItem> foodItemsList = fetchFoodItemsList(restaurantId);
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurant(restaurantId);
		return createFoodCataloguePage(foodItemsList, restaurant);
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemsList, Restaurant restaurant) {
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemsList(foodItemsList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;

	}

	private Restaurant fetchRestaurantDetailsFromRestaurant(Integer restaurantId) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/restaurants/" + restaurantId,
				Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemsList(Integer restaurantId) {
		return foodItemRepo.findByRestaurantId(restaurantId);
	}

}

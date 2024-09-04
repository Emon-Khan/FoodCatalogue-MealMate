package com.shikbetumio.foodcatelogue.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbetumio.foodcatelogue.dto.FoodCataloguePage;
import com.shikbetumio.foodcatelogue.dto.FoodItemDTO;
import com.shikbetumio.foodcatelogue.dto.Restaurant;
import com.shikbetumio.foodcatelogue.entity.FoodItem;
import com.shikbetumio.foodcatelogue.service.FoodCatalogueService;

public class FoodCatalogueControllerTest {
	@InjectMocks
	FoodCatalogueController foodCatalogueController;

	@Mock
	FoodCatalogueService foodCatalogueService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateFoodItem() {
		FoodItemDTO mockFoodItemDTO = new FoodItemDTO(201, "Margherita Pizza",
				"Classic pizza with fresh mozzarella, tomatoes, and basil", true, 8.99, 301, 2);
		when(foodCatalogueService.createFoodItem(mockFoodItemDTO)).thenReturn(mockFoodItemDTO);

		ResponseEntity<FoodItemDTO> response = foodCatalogueController.createFoodItem(mockFoodItemDTO);

		verify(foodCatalogueService, times(1)).createFoodItem(mockFoodItemDTO);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockFoodItemDTO, response.getBody());

	}

	@Test
	public void testGetCataloguePage() {
		Integer mockRestaurantId = 1;
		FoodCataloguePage mockFoodCataloguePage = new FoodCataloguePage(
				Arrays.asList(
						new FoodItem(1, "Margherita Pizza", "Classic pizza with fresh mozzarella, tomatoes, and basil",
								true, 8.99, mockRestaurantId, 2),
						new FoodItem(2, "Margherita Pizza", "Classic pizza with fresh mozzarella, tomatoes, and basil",
								true, 8.99, mockRestaurantId, 2)),
				new Restaurant(mockRestaurantId, "The Gourmet Kitchen", "789 Culinary Ave, Suite 10", "San Francisco",
						"A fine dining restaurant offering a fusion of international cuisines with a focus on local ingredients."));
		when(foodCatalogueService.getCataloguePage(mockRestaurantId)).thenReturn(mockFoodCataloguePage);

		ResponseEntity<FoodCataloguePage> response = foodCatalogueController.getCataloguePage(mockRestaurantId);

		verify(foodCatalogueService, times(1)).getCataloguePage(mockRestaurantId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockFoodCataloguePage, response.getBody());

	}

}

package com.shikbetumio.foodcatelogue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.shikbetumio.foodcatelogue.dto.FoodCataloguePage;
import com.shikbetumio.foodcatelogue.dto.FoodItemDTO;
import com.shikbetumio.foodcatelogue.dto.Restaurant;
import com.shikbetumio.foodcatelogue.entity.FoodItem;
import com.shikbetumio.foodcatelogue.mapper.FoodItemMapper;
import com.shikbetumio.foodcatelogue.repo.FoodItemRepo;

public class FoodCatalogueServiceTest {
	@InjectMocks
	FoodCatalogueService foodCatalogueService;

	@Mock
	FoodItemRepo foodItemRepo;

	@Mock
	RestTemplate restTemplate;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateFoodItem() {
		FoodItemDTO mockFoodItemDTO = new FoodItemDTO(1, "Margherita Pizza",
				"Classic pizza with fresh mozzarella, tomatoes, and basil", true, 8.99, 1, 2);
		FoodItem mockFoodItem = FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(mockFoodItemDTO);
		when(foodItemRepo.save(mockFoodItem)).thenReturn(mockFoodItem);

		FoodItemDTO foodItemDTO = foodCatalogueService.createFoodItem(mockFoodItemDTO);

		verify(foodItemRepo, times(1)).save(mockFoodItem);
		assertEquals(mockFoodItemDTO, foodItemDTO);
	}

	@Test
	public void testGetCataloguePage() {
		Integer mockRestaurantId = 1;
		List<FoodItem> mockFoodItems = Arrays.asList(
				new FoodItem(1, "Margherita Pizza", "Classic pizza with fresh mozzarella, tomatoes, and basil", true,
						8.99, mockRestaurantId, 2),
				new FoodItem(2, "Margherita Pizza", "Classic pizza with fresh mozzarella, tomatoes, and basil", true,
						8.99, mockRestaurantId, 2));
		Restaurant mockRestaurant = new Restaurant(mockRestaurantId, "The Gourmet Kitchen",
				"789 Culinary Ave, Suite 10", "San Francisco",
				"A fine dining restaurant offering a fusion of international cuisines with a focus on local ingredients.");
		FoodCataloguePage mockFoodCataloguePage = new FoodCataloguePage(mockFoodItems, mockRestaurant);
		when(foodItemRepo.findByRestaurantId(mockRestaurantId)).thenReturn(mockFoodItems);
		when(restTemplate.getForObject(anyString(), eq(Restaurant.class))).thenReturn(mockRestaurant);

		FoodCataloguePage foodCataloguePage = foodCatalogueService.getCataloguePage(mockRestaurantId);

		verify(foodItemRepo, times(1)).findByRestaurantId(mockRestaurantId);
		verify(restTemplate, times(1)).getForObject(anyString(), eq(Restaurant.class));
		assertEquals(mockFoodCataloguePage, foodCataloguePage);
	}

}

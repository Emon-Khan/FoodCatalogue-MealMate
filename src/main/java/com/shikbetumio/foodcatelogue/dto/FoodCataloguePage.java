package com.shikbetumio.foodcatelogue.dto;

import java.util.List;

import com.shikbetumio.foodcatelogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {
	private List<FoodItem> foodItemsList;
	private Restaurant restaurant;
}

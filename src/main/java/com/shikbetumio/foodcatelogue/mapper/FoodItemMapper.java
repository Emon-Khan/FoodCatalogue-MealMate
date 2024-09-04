package com.shikbetumio.foodcatelogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shikbetumio.foodcatelogue.dto.FoodItemDTO;
import com.shikbetumio.foodcatelogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
}

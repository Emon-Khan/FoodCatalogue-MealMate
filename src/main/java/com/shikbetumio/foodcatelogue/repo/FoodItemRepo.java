package com.shikbetumio.foodcatelogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shikbetumio.foodcatelogue.entity.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {

	List<FoodItem> findByRestaurantId(int restaurantId);

}

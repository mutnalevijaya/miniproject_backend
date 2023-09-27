package com.govtech.miniproject.service;


import com.govtech.miniproject.dto.AddRestaurantRequestDTO;
import com.govtech.miniproject.dto.ViewRestaurantsResponseDTO;

import java.util.List;

public interface IRestuarantService {

    boolean addRestaurant(AddRestaurantRequestDTO addRestaurantRequestDTO);

    List<ViewRestaurantsResponseDTO> viewRestaurants();

    String getRandomRestaurant();
}

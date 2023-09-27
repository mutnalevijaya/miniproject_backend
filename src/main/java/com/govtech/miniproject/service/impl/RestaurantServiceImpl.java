package com.govtech.miniproject.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.govtech.miniproject.dto.AddRestaurantRequestDTO;
import com.govtech.miniproject.dto.ViewRestaurantsResponseDTO;
import com.govtech.miniproject.entity.TRestaurantsMS;
import com.govtech.miniproject.repository.RestaurantMSRepository;
import com.govtech.miniproject.service.IRestuarantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements IRestuarantService {

    private final RestaurantMSRepository restaurantMSRepository;

    @Override
    public boolean addRestaurant(AddRestaurantRequestDTO addRestaurantRequestDTO) {

        TRestaurantsMS restaurantsMS = new TRestaurantsMS();
        restaurantsMS.setId(UUID.randomUUID().toString());
        restaurantsMS.setName(addRestaurantRequestDTO.getName());

        Optional<TRestaurantsMS> tRestaurantsMS = restaurantMSRepository.findByName(addRestaurantRequestDTO.getName());

        if(tRestaurantsMS.isPresent()){

            tRestaurantsMS.get().setCount(tRestaurantsMS.get().getCount()+1);
            restaurantMSRepository.save(tRestaurantsMS.get());
            return true;
        }

        restaurantsMS.setCount(0L);
        restaurantMSRepository.save(restaurantsMS);
        return true;
    }

    @Override
    public List<ViewRestaurantsResponseDTO> viewRestaurants() {
        List<TRestaurantsMS> tRestaurantsMSList = restaurantMSRepository.findAll();
        return tRestaurantsMSList.stream().map(r -> ViewRestaurantsResponseDTO.builder().id(r.getId()).name(r.getName()).count(r.getCount()).build()).collect(Collectors.toList());
    }

    @Override
    public String getRandomRestaurant() {
        return restaurantMSRepository.getRandomRestaurantName();
    }
}

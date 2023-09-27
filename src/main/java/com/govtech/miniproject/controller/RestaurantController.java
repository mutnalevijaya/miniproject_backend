package com.govtech.miniproject.controller;

import com.govtech.miniproject.dto.AddRestaurantRequestDTO;
import com.govtech.miniproject.dto.ViewRestaurantsResponseDTO;
import com.govtech.miniproject.service.IRestuarantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/restaurant")
@CrossOrigin(origins = "http://localhost:4200/")
public class RestaurantController {

    private final IRestuarantService restuarantService;

    @PostMapping("/add")
    public void addRestaurant(@Valid @RequestBody AddRestaurantRequestDTO addRestaurantRequestDTO){
        restuarantService.addRestaurant(addRestaurantRequestDTO);
    }

    @GetMapping("/get")
    public List<ViewRestaurantsResponseDTO> getRestaurant(){
        return restuarantService.viewRestaurants();
    }
    @GetMapping("/random")
    public String getRandomRestaurant(){
        return restuarantService.getRandomRestaurant();
    }
}

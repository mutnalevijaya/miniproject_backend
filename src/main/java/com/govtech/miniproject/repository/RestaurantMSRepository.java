package com.govtech.miniproject.repository;

import com.govtech.miniproject.entity.TRestaurantsMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RestaurantMSRepository extends JpaRepository<TRestaurantsMS, String> {

    Optional<TRestaurantsMS> findByName(String name);

    @Query(value = "SELECT TOP 1 name FROM T_RESTAURANT_MS ORDER BY NEWID()", nativeQuery = true)
    String getRandomRestaurantName();
}

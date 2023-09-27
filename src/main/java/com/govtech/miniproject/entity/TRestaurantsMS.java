package com.govtech.miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "T_RESTAURANT_MS", schema = "dbo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TRestaurantsMS {

    /*
        Primary key column for the table.
        unique identity for each row
     */
    @Id
    @Column(name = "ID")
    private String id;

    /*
        Name of the restaurant
     */
    @Column(name = "NAME", nullable = true)
    private String name;

    /*
      Count of restaurants. Count will be updated when user enters the restaurant name
     */
    @Column(name = "COUNT", nullable = true)
    private Long count;
}

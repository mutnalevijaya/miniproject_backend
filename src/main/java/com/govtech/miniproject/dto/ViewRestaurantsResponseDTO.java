package com.govtech.miniproject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ViewRestaurantsResponseDTO {

    private String id;
    private String name;
    private long count;
}

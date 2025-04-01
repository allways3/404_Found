package com.multi.travel_404.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelDTO {
    private int no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
    private int count;

    private Long id;
    private String name;
    private double latitude;
    private double longitude;
}

package com.multi.travel_404.travel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

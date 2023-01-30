package com.melita.ordertrackingapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private int id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String email;
    private String address;
}

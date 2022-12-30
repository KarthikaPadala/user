package com.student.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddressDto {
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;


}

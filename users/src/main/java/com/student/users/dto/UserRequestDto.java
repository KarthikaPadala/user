package com.student.users.dto;
import com.student.users.model.Address;
import lombok.Data;
@Data
public class UserRequestDto {
    private String userName;
    private String email;
    private Address address;
}

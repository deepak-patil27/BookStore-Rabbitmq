package com.bridgelabz.bookstorerabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String userId;
    private String Address;
    private String email;
    private String firstName;
    private String lastName;

}

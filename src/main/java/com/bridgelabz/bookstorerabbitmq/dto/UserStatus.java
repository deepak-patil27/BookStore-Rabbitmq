package com.bridgelabz.bookstorerabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserStatus {

    private User user;
    private String status;//progress,completed
    private String message;
}


package com.bridgelabz.bookstorerabbitmq.publisher;

import com.bridgelabz.bookstorerabbitmq.config.MessagingConfig;
import com.bridgelabz.bookstorerabbitmq.dto.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/userdetails")
public class UserPublisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{register}")
    public String registerUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        UserStatus userStatus = new UserStatus(user, "PROCESS", "User registered succesfully");
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, userStatus);
        return "Success !!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Login login) {
        login.setLoginID(UUID.randomUUID().toString());
        LoginStatus loginStatus = new LoginStatus(login, "PROCESS", "User logged in successfully" );
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, loginStatus);
        return "Success !!";
    }

    @PostMapping("/changepassword")
    public String userChangepassword(@RequestBody Changepassword changepassword) {
        changepassword.setChangepasswordID(UUID.randomUUID().toString());
        ChangepasswordStatus changepasswordStatus = new ChangepasswordStatus(changepassword, "PROCESS", "password changed successfully" );
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY,changepasswordStatus);
        return "Success !!";
    }



}

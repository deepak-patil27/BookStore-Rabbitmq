package com.bridgelabz.bookstorerabbitmq.publisher;

import com.bridgelabz.bookstorerabbitmq.config.MessagingConfig;
import com.bridgelabz.bookstorerabbitmq.dto.Order;
import com.bridgelabz.bookstorerabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{insert}")
    public String insertOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully");
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}

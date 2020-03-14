package ru.dias.spring1boot.controllers;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
public class MainController {
    // https://getbootstrap.com/docs/4.1/getting-started/introduction/
    private final static String QUEUE_NAME = "auth_user";

    @RequestMapping("/")
    public String showHomePage() throws IOException, TimeoutException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String msg = "Пользователь " + auth.getName().toString() + " зашел на сайт.";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        }
        return "index";
    }    
}

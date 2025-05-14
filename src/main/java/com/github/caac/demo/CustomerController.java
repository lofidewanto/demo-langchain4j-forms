package com.github.caac.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerAgenticService customerAgenticService;

    public CustomerController(CustomerAgenticService customerAgenticService) {
        this.customerAgenticService = customerAgenticService;
    }

    @PostMapping("/customer_chat")
    public ResponseEntity<String> chat(String chatId, String userMessage) {
        logger.info("Chat ID: {}", chatId);
        logger.info("User Message: {}", userMessage);
        
        String responseMessage = customerAgenticService.chatWithAgents(chatId, userMessage);

        return ResponseEntity.ok()
                .body(responseMessage);
    }

}

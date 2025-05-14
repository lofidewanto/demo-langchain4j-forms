package com.github.caac.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerAgenticServiceIT {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAgenticServiceIT.class);

    @Autowired
    CustomerAgenticService customerAgenticService;

    @Test
    void chat_with_agents_just_need_a_help() {
        String chatId = "help" + System.currentTimeMillis();
        String userMessage = "Hello, I want to apply for a travel insurance.";
        logger.info("*** Request: " + userMessage);

        String chatWithAgents = customerAgenticService.chatWithAgents(chatId, userMessage);
        logger.info("*** Response: " + chatWithAgents);

        // Assertions can be added here to validate the behavior

        userMessage = """
                    Name: John Doe; 
                    Address: Schönhauser 10, 50968 Köln; 
                    Telephone: 0123456789"; 
                    Email: lofi@lofi.de
                    
                    
                """;
        chatWithAgents = customerAgenticService.chatWithAgents(chatId, userMessage);
        logger.info("*** Response: " + chatWithAgents);

        userMessage = """
                Begin date should be tommorow.
                Only for me, one person.
                """;
        chatWithAgents = customerAgenticService.chatWithAgents(chatId, userMessage);
        logger.info("*** Response: " + chatWithAgents);
    }

}

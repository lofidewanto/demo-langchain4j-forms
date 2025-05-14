package com.github.caac.demo;

import dev.langchain4j.service.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerAgenticService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAgenticService.class);

    private CustomerAgent customerAgent;

    public CustomerAgenticService(CustomerAgent customerAgent) {
        this.customerAgent = customerAgent;
    }

    public String chatWithAgents(String chatId, String userMessage) {
            Result<String> chatCustomer = customerAgent.chat(chatId, userMessage);
            logger.info("*** CustomerAgent content: {}", chatCustomer.content());
            logger.info("*** CustomerAgent tools: {}", chatCustomer.toolExecutions());

            return chatCustomer.content();
    }
}

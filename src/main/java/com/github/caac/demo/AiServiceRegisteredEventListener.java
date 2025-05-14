package com.github.caac.demo;

import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.service.spring.event.AiServiceRegisteredEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AiServiceRegisteredEventListener implements ApplicationListener<AiServiceRegisteredEvent> {

    private static final Logger logger = LoggerFactory.getLogger(AiServiceRegisteredEventListener.class);

    @Override
    public void onApplicationEvent(@NonNull AiServiceRegisteredEvent event) {
        Class<?> aiServiceClass = event.aiServiceClass();
        List<ToolSpecification> toolSpecifications = event.toolSpecifications();

        int index = 1;
        for (ToolSpecification toolSpecification : toolSpecifications) {
            logger.info("[%s]: [Tool-%d]: %s%n", "Tools: " + aiServiceClass.getSimpleName(), index++,
                    toolSpecification);
        }
    }
}
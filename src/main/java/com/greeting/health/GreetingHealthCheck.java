package com.greeting.health;

import com.codahale.metrics.health.HealthCheck;

public class GreetingHealthCheck extends HealthCheck{
    private final String greeting;

    public GreetingHealthCheck(String greeting) {
        this.greeting = greeting;
    }

    @Override
    protected Result check() throws Exception {
        final String text = String.format(greeting, "TEST");
        if (!text.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}

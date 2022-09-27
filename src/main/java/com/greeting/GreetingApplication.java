package com.greeting;

import com.greeting.health.GreetingHealthCheck;
import com.greeting.resource.GreetingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GreetingApplication extends Application<GreetingConfiguration> {
    public static void main(String[] args) throws Exception {
        new GreetingApplication().run(args);
    }

    @Override
    public String getName() {
        return "greet";
    }

    @Override
    public void initialize(Bootstrap<GreetingConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(GreetingConfiguration greetingConfiguration, Environment environment) throws Exception {
        final GreetingResource resource = new GreetingResource(
                greetingConfiguration.getGreeting(),
                greetingConfiguration.getDefaultName()
        );
        final GreetingHealthCheck healthCheck =
                new GreetingHealthCheck(greetingConfiguration.getGreeting());

        environment.healthChecks().register("greeting", healthCheck);
        environment.jersey().register(resource);
    }

}

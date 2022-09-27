package com.greeting;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class GreetingConfiguration extends Configuration {
    @NotEmpty
    private String greeting;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getGreeting() {
        return greeting;
    }

    @JsonProperty
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}

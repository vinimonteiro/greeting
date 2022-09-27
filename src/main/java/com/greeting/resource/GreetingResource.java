package com.greeting.resource;

import com.codahale.metrics.annotation.Timed;
import com.greeting.dto.Text;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {
        private final String greeting;
        private final String defaultName;

        public GreetingResource(String greeting, String defaultName) {
            this.greeting = greeting;
            this.defaultName = defaultName;
        }

        @GET
        @Timed
        public Text sayHello(@QueryParam("name") Optional<String> name) {
            final String value = String.format(greeting, name.orElse(defaultName));
            return new Text(value);
        }
}

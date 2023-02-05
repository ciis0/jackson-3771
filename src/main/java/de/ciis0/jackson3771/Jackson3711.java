package de.ciis0.jackson3771;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class Jackson3711 extends Application
{
    @PostConstruct
    public void leak()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().introspect(mapper.constructType(Foo.class));
        System.out.println("leak complete");
    }
}
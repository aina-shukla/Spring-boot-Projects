package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    List<Movie> movies;

    @PostConstruct
    public void pushMovies(){
        movies = Arrays.asList(
            new Movie(125, "Comedy Movie", "Me", 2.5),
            new Movie(241, "Horror Movie", "He", 4.5),
            new Movie(524, "Ramance Movie", "She", 4.9),
            new Movie(971, "Social Movie", "We", 3.1)
        );
    }


    @Bean
    public Supplier<APIGatewayProxyResponseEvent> getAllMovies(){

        Supplier<APIGatewayProxyResponseEvent> s = ()->{
            System.out.println("Returning all movies");
                return new APIGatewayProxyResponseEvent().withBody(movies.toString()).withStatusCode(200);
            };

            return s;
    }


    @Bean
    public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> searchByRating(){
        Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> func = (event)->{

            // endpointpath?rating=3.1
            double rating = Double.parseDouble(event.getQueryStringParameters().get("rating"));

            List<Movie> filterMovies = new ArrayList<>();

            for(Movie m : movies){
                if(m.getRating() > rating){
                    filterMovies.add(m);
                }
            }

            return new APIGatewayProxyResponseEvent().withBody(filterMovies.toString()).withStatusCode(200);
        };

        return func;
    }
    
}
package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Please enter a StopPoint:");
        Scanner scanner = new Scanner(System.in);
        String stopPoint = scanner.next();

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Bus[] response = client.target("https://api.tfl.gov.uk/StopPoint/" + stopPoint +"/Arrivals")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Bus[].class);

        List<String> NextFiveBuses = new ArrayList<>();
//        for (Bus bus : response) {
        for (int i = 0; i <5; i++) {
//            System.out.println(response[i].destinationName);
//            System.out.println(response[i].lineName);
//            System.out.println(response[i].timeToStation);
            System.out.printf("This next bus is the %s to %s. It arrives in %d seconds\n\n", response[i].lineName, response[i].destinationName, response[i].timeToStation);
        }


//        System.out.println(NextFiveBuses);

    }
}	

package com.publicis.sapient.parking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicis.sapient.parking.model.ParkingSpot;
import com.publicis.sapient.parking.service.impl.ParkingSpotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ParkingApplication implements CommandLineRunner{

	@Autowired
	private ParkingSpotServiceImpl parkingSpotService;

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<ParkingSpot>> typeReference = new TypeReference<List<ParkingSpot>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/parking.json");
		try {
			List<ParkingSpot> parkingSpots = objectMapper.readValue(inputStream, typeReference);
			parkingSpotService.saveAllParkings(parkingSpots);
			System.out.println("saved parking");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("error");
		}
	}
}

package ma.makla.maklaservices.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.makla.maklaservices.model.dto.CardRestaurant;
import ma.makla.maklaservices.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping
	public List<CardRestaurant> findAll() {
		return restaurantService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CardRestaurant findById(@PathVariable("id") Long id) {
		return restaurantService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CardRestaurant cardRestaurant, HttpServletRequest request) {
		CardRestaurant carRestaurantP = restaurantService.create(cardRestaurant);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carRestaurantP.getId()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
	
	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	

}

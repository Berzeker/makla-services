package ma.makla.maklaservices.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.makla.maklaservices.model.dto.CardRestaurant;
import ma.makla.maklaservices.model.entity.Restaurant;
import ma.makla.maklaservices.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CardRestaurant> findAll() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants.stream().map(x -> modelMapper.map(x, CardRestaurant.class)).collect(Collectors.toList());
		
	}
	
	public CardRestaurant findById(Long id) {
		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
		return modelMapper.map(restaurant.get(), CardRestaurant.class);
		
	}
	
	
	public CardRestaurant create(CardRestaurant cardRestaurant) {
		Restaurant restaurant = modelMapper.map(cardRestaurant, Restaurant.class);
		restaurant = restaurantRepository.save(restaurant);
		return modelMapper.map(restaurant, CardRestaurant.class);
	}
	
	
	
}

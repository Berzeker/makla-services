package ma.makla.maklaservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.makla.maklaservices.model.entity.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}

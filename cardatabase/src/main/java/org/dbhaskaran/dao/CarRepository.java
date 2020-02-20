package org.dbhaskaran.dao;

import java.util.List;

import org.dbhaskaran.dto.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	// Fetch cars by brand
	List<Car> findByBrand(String brand);

	// Fetch cars by color
	List<Car> findByColor(String color);

}

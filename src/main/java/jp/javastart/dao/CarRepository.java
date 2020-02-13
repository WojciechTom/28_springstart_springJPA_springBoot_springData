package jp.javastart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jp.javastart.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findFirstByBrand(String brand);
	
	List<Car> findFirstByPrice(Double price);
	
	
	
}

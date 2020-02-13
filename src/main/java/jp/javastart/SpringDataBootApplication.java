package jp.javastart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;

import jp.javastart.dao.CarRepository;
import jp.javastart.model.Car;


@SpringBootApplication
public class SpringDataBootApplication{

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBootApplication.class, args);
		
		
		List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mondeo", "Ford", 19000.0));
        cars.add(new Car("Octavia", "Skoda", 35000.0));
        cars.add(new Car("Superb", "Skoda", 29500.0));
        cars.add(new Car("Felicia", "Skoda", 39500.0));
        cars.add(new Car("Octavia Combi", "Skoda", 19500.0));
        cars.add(new Car("407", "Peugeot", 1229500.0));
        cars.add(new Car("207", "Peugeot", 429500.0));
        cars.add(new Car("106", "Peugeot", 129500.0));
        cars.add(new Car("Cactus", "Citroen", 1500.0));
        cars.add(new Car("Panda", "Fiat", 15500.0));
		
        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); 
        
        //Car firstCar = carRepo.findById(9L).get(); 
        //carRepo.delete(firstCar); 
        
        
        //carRepo.findAll().forEach(System.out::println);
        //carRepo.findAll(new PageRequest(2,10)).getContent().forEach(System.out::println);
        carRepo.findFirstByBrand("Skoda").forEach(System.out::println);
        
        ctx.close();
	
	}

}

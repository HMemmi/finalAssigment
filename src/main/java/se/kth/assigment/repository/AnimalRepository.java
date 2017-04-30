package se.kth.assigment.repository;

import java.io.BufferedReader;
import java.util.List;

import se.kth.assigment.model.Animal;
import se.kth.assigment.service.Order;

/**
 * This interface implemented by {@link AnimalRepositoryImpl}
 * @author Hichem Memmi
 *
 */
public interface AnimalRepository {

	BufferedReader getAllAnimals();
	void exportToCSV(List<Animal> animals, Order order);
	void sendToServer(List<Animal> animals, Order order);

}
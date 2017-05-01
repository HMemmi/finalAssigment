package se.kth.assigment.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import se.kth.assigment.model.Animal;

public interface AnimalService {

	/**
	 * This method is to get all animals from the csv file and it eliminate all animals that has a wrong date
	 * @return
	 * 	this method returns a {@link List} of {@link Animal}
	 * @throws FileNotFoundException
	 * 			this method can throw {@link FileNotFoundException}
	 * @throws IOException
	 * 			this method can throw {@link IOException}
	 */
	List<Animal> getAllAnimals() throws FileNotFoundException, IOException;

	/**
	 * This method is to export csv file
	 * @param animals
	 * 		{@link List} of {@link Animal}
	 * @param order
	 * 			{@link Order}
	 */
	void exportToCSV(List<Animal> animals, Order order);

	/**
	 * This method is to send a collection to a server
	 * @param animals
	 *   	list of {@link Animal}
	 * @param order
	 * 			{@link Order}
	 */
	void sendToServer(List<Animal> animals, Order order);
}
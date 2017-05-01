package se.kth.assigment.service;

import java.util.List;

import se.kth.assigment.model.Animal;

/**
 * This interface implemented by {@link AnimalUtilities}
 * 
 * @author Hichem Memmmi
 * @version 30/04/2017
 */
public interface SortedList {
	/**
	 * Sort a collection asc or desc based on the input parameter of type
	 * {@link Order}
	 * 
	 * @param animals
	 *            {@link List} of {@link Animal}
	 * @param order
	 *            {@link Order}
	 */
	void sortByDate(List<Animal> animals, Order order);
}

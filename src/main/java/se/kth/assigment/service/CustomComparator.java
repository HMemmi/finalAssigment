package se.kth.assigment.service;

import java.util.Comparator;

import se.kth.assigment.model.Animal;

/**
 * This class is a custom comparator to get a collection sorted by the user
 * choice
 * 
 * @author Hichem Memmi
 * @version 29/04/2017
 */
public class CustomComparator {

	/**
	 * This method returns a {@link Comparator}, it compare names
	 * 
	 * @param order
	 *            of type {@link Order}
	 * @return {@link Comparator}
	 */
	public static Comparator<Animal> comparatorByName(Order order) {

		return new Comparator<Animal>() {
			@Override
			public int compare(Animal s1, Animal s2) {
				// if ASC passed as parameter compare s1 to s2, otherwise
				// compare s2 to s1
				return (Order.ASC.equals(order)) ? s1.getName().compareTo(s2.getName())
						: s2.getName().compareTo(s1.getName());
			}
		};
	}

	/**
	 * This method returns a {@link Comparator}, it compare dates
	 * 
	 * @param order
	 *            of type {@link Order}
	 * @return {@link Comparator}
	 */
	public static Comparator<Animal> comparatorByDate(Order order) {

		return new Comparator<Animal>() {
			@Override
			public int compare(Animal s1, Animal s2) {
				// if ASC passed as parameter compare s1 to s2, otherwise
				// compare s2 to s1
				return (Order.ASC.equals(order)) ? s1.getYear().compareTo(s2.getYear())
						: s2.getYear().compareTo(s1.getYear());
			}
		};
	}

}

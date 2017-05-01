package se.kth.assigment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import se.kth.assigment.model.Animal;

@Service("sortedList")
public class AnimalUtilities implements SortedList {


	/**
	 * This method is to filter a collection of {@link Animal}
	 * 
	 * @param animals
	 *            List of {@link Animal}
	 * @param predicate
	 *            a {@link Predicate}
	 * @param consumer
	 *            a {@link Consumer}
	  */
	
	public static void filter(List<Animal> animals, Predicate<String> predicate, BiConsumer<Integer, Animal> consumer) {
		int i = 0;
		for (Animal animal : animals) {
			if (predicate.test(animal.getName())) {
				consumer.accept(++i, animal);
			}
		}
	}

	public static List<Animal> filter(List<Animal> animals, Predicate<String> predicate) {
		List<Animal> animalsToReturn = new ArrayList<>();
		for (Animal animal : animals) {
			if (predicate.test(animal.getName())) {
				animalsToReturn.add(animal);
			}
		}
		return animalsToReturn;
	}

	/**
	 * This method is to filter Animals based on if they can swim
	 * 
	 * @param animals
	 *            {@link List} of {@link Animal}
	 * @param predicate
	 *            A {@link Predicate}
	 * @return return {@link List} of {@link Animal}
	 */
	public static List<Animal> swimmersFilter(List<Animal> animals, Predicate<Animal> predicate) {
		List<Animal> animalsToReturn = new ArrayList<>();
		for (Animal animal : animals) {
			if (predicate.test(animal)) {
				animalsToReturn.add(animal);
			}
		}
		return animalsToReturn;
	}

	/**
	 * This method is to sort a collection
	 */
	@Override
	public void sortByDate(List<Animal> animals, Order order) {
		animals.sort(CustomComparator.comparatorByDate(order));
	}

}

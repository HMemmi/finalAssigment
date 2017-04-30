package se.kth.assigment.startup;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.kth.assigment.model.Animal;
import se.kth.assigment.model.Swimmer;
import se.kth.assigment.service.AnimalService;
import se.kth.assigment.service.AnimalUtilities;
import se.kth.assigment.service.CustomComparator;
import se.kth.assigment.service.Order;

public class Main {

	private static ApplicationContext applicationContext;

	public static void main(String args[]) throws Exception {

		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		AnimalService animalService = applicationContext.getBean("animalService", AnimalService.class);

		System.out.println("Reading from CSV file");
		// Get the list of animals from csvReader.readAnimalsFromCSV()
		List<Animal> animals = animalService.getAllAnimals();
		System.out.println(animals);

		// animals Sorted by name ASC
		System.out.println("List of animal sorted by name order ASC ");
		animals.sort(CustomComparator.comparatorByName(Order.ASC));
		System.out.println(animals);

		// animals Sorted by name DESC
		System.out.println("List of animal sorted by name order DESC ");
		animals.sort(CustomComparator.comparatorByName(Order.DESC));
		System.out.println(animals);

		// filter a list of Animal, get animal list which their names beginning
		// with j

		List<Animal> animals1 = animalService.getAllAnimals();

		System.out.println("printing out the animals after filtering using BiConsumer");
		AnimalUtilities.filter(animals1, (String name) -> name.startsWith("j"), (Integer number, Animal animal) -> {
			System.out.println(number + " " + animal);
		});

		System.out.println("printing out the whole collection animals after filtering");
		List<Animal> animalsAfterFilter = AnimalUtilities.filter(animals1, (String name) -> name.startsWith("j"));
		System.out.println(animalsAfterFilter);

		System.out.println("printing out animals can swim");
		// Get a list of Animals which can swim
		List<Animal> swimmers = AnimalUtilities.swimmersFilter(animals1, (Animal animal) -> animal instanceof Swimmer);

		System.out.println(swimmers);

		animalService.exportToCSV(animals, Order.ASC);
		animalService.exportToCSV(animals, Order.DESC);

		try{
			animalService.sendToServer(animals, Order.ASC);
			animalService.sendToServer(animals, Order.DESC);
		}
		catch(Exception e){
			System.out.println("Open your server, your server is closed so we can't send your request");
		}
		

	}

}

package se.kth.assigment.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import se.kth.assigment.model.Animal;
import se.kth.assigment.repository.AnimalRepository;
/**
 *This class is a {@link AnimalServiceImpl} which allow the user to read a csv file and bind them to animals
 * @author Hichem Memmi
 *@version 29/04/2017
 */

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private SortedList sortedList;
	
	
	//every time this method called it will eliminate not valid years
	@Override
	public List<Animal> getAllAnimals() throws FileNotFoundException, IOException {
		BufferedReader br=animalRepository.getAllAnimals();
		List<Animal> animals = br.lines().map(mapToAnimal)
				.filter(animal -> !(animal==null)&&MyAnnotationHanlder.handleAnimal(animal))
				.collect(Collectors.toList());
		br.close();
		return animals;
	}
	
	
	
	
	/* private method of type Function which returns animal from one line of the csv file, and this animal
	represent an element of the collection which will returned when the user call readAnimalsFromCSV method*/
	private Function<String, Animal> mapToAnimal = (line) -> {
		Animal animal = null;
		if (!line.equals("")) {
			List<String> list = Lists.newArrayList(Splitter.on(",").splitToList(line));
			try {
				animal = createObject(list.get(0), list.get(1), list.get(2));
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return animal;

	};

	/*
	 * This method is responsible to create an object of Animal and it is called by mapToAnimal method
	 */
	private Animal createObject(String type, String name, String year) throws Exception {
		String typeAfterCapitilizing = WordUtils.capitalize(type).replaceAll("\\s","");
		Animal animal=(Animal) Class.forName(Animal.class.getPackage().getName().toString()+"."+typeAfterCapitilizing).newInstance();
		animal.setType(typeAfterCapitilizing);
		animal.setName(name);
		animal.setYear(year);
	
		return animal;
	}

	@Override
	public void exportToCSV(List<Animal> animals, Order order) {
		sortedList.sortByDate(animals, order);
		animalRepository.exportToCSV(animals,order);
	}

	@Override
	public void sendToServer(List<Animal> animals, Order order) {
		sortedList.sortByDate(animals, order);
		animalRepository.sendToServer(animals,order);
	}
	
	
	
	
}

package se.kth.assigment.model;

import java.util.Objects;

import org.springframework.stereotype.Component;

import se.kth.assigment.service.ValidYear;
/**
 * This class is an abstract class that extends by {@link ArabianHorse}, {@link BengalCat}, {@link Chicken}
 *, {@link Dolphin}, {@link Duck}, {@link GermanShepherd}, {@link GoldenRetriever}, {@link GreatWhiteShark},
 * and {@link Parakeet}
 * @author Hichem Memmi
 *@version 29/04/2017
 *
 */

@Component
public abstract class Animal {
	
	private String type;
	private String name;

	//This annotation is to check if the year is valid 
	@ValidYear
	private String year;

	/**
	 * Default constructor
	 */
	
	public Animal(){
		
	}
	
	
	
	public Animal(String type, String name, String year) {
		super();
		this.type = type;
		this.name = name;
		this.year = year;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return this.getType() + ", " + this.getName() + ", " + this.getYear() + "\n";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return  Objects.equals(type, animal.type) &&
                Objects.equals(name, animal.name)
                &&
                Objects.equals(year, animal.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name,year);
    }
	

}

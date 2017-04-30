package se.kth.assigment.service;

import java.lang.reflect.Field;

import se.kth.assigment.model.Animal;

public class MyAnnotationHanlder {
	
	//private method to check if a year matches the system requirement
    private static boolean innerHandle(Object object, Field[] fields) {
        for(Field field : fields) {
            if (field.isAnnotationPresent(ValidYear.class)) {
            	field.setAccessible(true);
                try {
                	//date should be between 1999 and 2099, and has no char
					return field.get(object).toString().matches("^(19|20)\\d{2}$");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}   
            }
        }
		return false;
   }
    
    /**
     * This method is to check every field annotated by @ValidYear and check if the year is valid
     * and it print out a warning
     * @param animal
     *   animal of type {@link Animal}
     * @return
     * 		{@link Boolean}
     */
    public static boolean handleAnimal(Animal animal){
    	Field[] fields = animal.getClass().getSuperclass().getDeclaredFields();
    	if(!innerHandle(animal,fields)){
    		/* Message printed every time the user try to read data from csv file. because this method
    		triggered by getAllAnimals which located in AnimalServiceImplTest class*/
    		System.out.println("warning "+animal.getName()+" has a wrong date "+animal.getYear()+" thats why it has been removed");
    	}
    	return innerHandle(animal,fields);
    }
	
   }
   
		
		




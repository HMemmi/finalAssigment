package se.kth.assigment.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import se.kth.assigment.model.Animal;
import se.kth.assigment.service.Order;


@Repository("animalRepository")
public class AnimalRepositoryImpl implements AnimalRepository {

	
	/**
	 * This method is to get all Animals from the csv file
	 */
	@Override
	public BufferedReader getAllAnimals(){
		InputStream in = AnimalRepositoryImpl.class.getResourceAsStream("/animals.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	
	
	private static final String CSV_SEPARATOR = ",";
    
	
	/**
	 * This method is to export animals 
	 */
	@Override
	public void exportToCSV(final List<Animal> swimmers, Order order) {
		 try
	        {
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Swimmer_"+order.toString()+".csv"), "UTF-8"));
	            for (Animal swimmer : swimmers)
	            {
	                StringBuffer oneLine = createOneLine(swimmer);
	                bw.write(oneLine.toString());
	                bw.newLine();
	            }
	            bw.flush();
	            bw.close();
	            System.out.println("swimmers exported!");
	        }
	        catch (UnsupportedEncodingException e) {}
	        catch (FileNotFoundException e){}
	        catch (IOException e){}
	}

	
	/*
	 * this method is triggered by exportToCSV method, this method will handle the creating of one line
	 */
	private StringBuffer createOneLine(final Animal swimmer) {
		StringBuffer oneLine = new StringBuffer();
		oneLine.append(swimmer.getType().trim().length() == 0? "" : swimmer.getType());
		oneLine.append(CSV_SEPARATOR);
		oneLine.append(swimmer.getName().trim().length() == 0? "" : swimmer.getName());
		oneLine.append(CSV_SEPARATOR);
		oneLine.append(swimmer.getYear().trim().length() == 0? "" : swimmer.getYear());
		return oneLine;
	}

	/**
	 * This method will send the collection of swimmer to the server
	 */
	@Override
	public void sendToServer(List<Animal> swimmers, Order order) {
		 RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/FinalAssigmentSpringServer/swimmers/{order}";
	        Map<String,String> map=new HashMap<>();
	        map.put("order", order.toString());
	        restTemplate.put(url, swimmers,map);
	        System.out.println("swimmers sent to the server!");
	}


}

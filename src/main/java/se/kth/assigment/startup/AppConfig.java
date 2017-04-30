package se.kth.assigment.startup;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import se.kth.assigment.repository.AnimalRepositoryImpl;


/**
 * This class is to solve the dependency injection issues since i am using Autowired annotation
 * in {@link AnimalServiceImplTest} it is not needed to create beans here. But that doesn't mean we should 
 * delete this class. This class should be here or Springframework will note be able to
 *  automatically generate beans for annotated classes as {@link AnimalServiceImplTest} and {@link AnimalRepositoryImpl}
 * @author Hichem Memmi
 * @version 29/04/2017
 *
 */
@ComponentScan("se.kth.assigment")
@Configuration
public class AppConfig {

}

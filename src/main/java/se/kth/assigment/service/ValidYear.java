package se.kth.assigment.service;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*This is an annotation thats allow the user to check if a year is valid, it works by simply add  @ValidYear
 * @author Hichem Memmi
 * @version 29/04/2017
 *    
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidYear {
}

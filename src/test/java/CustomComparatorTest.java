import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.kth.assigment.model.Animal;
import se.kth.assigment.model.ArabianHorse;
import se.kth.assigment.model.Chicken;
import se.kth.assigment.model.Duck;
import se.kth.assigment.service.CustomComparator;
import se.kth.assigment.service.Order;

public class CustomComparatorTest {

	private List<Animal> animals;

	@Before
	public void setUp() throws Exception {
		ArabianHorse arabianHorse = new ArabianHorse("arabianHorse", "lucas", "2011");
		Duck duck = new Duck("duck", "duck", "1999");
		Chicken chicken = new Chicken("chicken", "chicken", "1989");
		animals = Arrays.asList(arabianHorse, duck, chicken);
	}

	@Test
	public final void testComparatorByNameOrderASC() {
		List<Animal> animalsExpected = Arrays.asList(new Chicken("chicken", "chicken", "1989"),
				new Duck("duck", "duck", "1999"), new ArabianHorse("arabianHorse", "lucas", "2011"));
		List<Animal> animalsActual = animals;
		animalsActual.sort(CustomComparator.comparatorByName(Order.ASC));
		assertThat(animalsActual, is(animalsExpected));
	}

	@Test
	public final void testComparatorByNameOrderDESC() {
		List<Animal> animalsExpected = Arrays.asList(new ArabianHorse("arabianHorse", "lucas", "2011"),
				new Duck("duck", "duck", "1999"), new Chicken("chicken", "chicken", "1989"));
		List<Animal> animalsActual = animals;
		animalsActual.sort(CustomComparator.comparatorByName(Order.DESC));
		assertThat(animalsActual, is(animalsExpected));
	}

	@Test
	public final void testComparatorByDateOrderByDESC() {
		List<Animal> animalsExpected = Arrays.asList(new ArabianHorse("arabianHorse", "lucas", "2011"),
				new Duck("duck", "duck", "1999"), new Chicken("chicken", "chicken", "1989"));
		List<Animal> animalsActual = animals;
		animalsActual.sort(CustomComparator.comparatorByDate(Order.DESC));
		assertThat(animalsActual, is(animalsExpected));
	}

	@Test
	public final void testComparatorByDateOrderByASC() {
		List<Animal> animalsExpected = Arrays.asList(new Chicken("chicken", "chicken", "1989"),
				new Duck("duck", "duck", "1999"), new ArabianHorse("arabianHorse", "lucas", "2011"));
		List<Animal> animalsActual = animals;
		animalsActual.sort(CustomComparator.comparatorByDate(Order.ASC));
		assertThat(animalsActual, is(animalsExpected));
	}

}

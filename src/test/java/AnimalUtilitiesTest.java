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
import se.kth.assigment.model.Swimmer;
import se.kth.assigment.service.AnimalUtilities;

public class AnimalUtilitiesTest {

	private List<Animal> animals;

	@Before
	public void setUp() throws Exception {
		animals = Arrays.asList(new ArabianHorse("arabianHorse", "lucas", "2011"), new Duck("duck", "duck", "1999"),
				new Chicken("chicken", "chicken", "1989"));
	}

	@Test
	public final void testFilter() {
		List<Animal> animalsExpected = Arrays.asList(new ArabianHorse("arabianHorse", "lucas", "2011"));
		List<Animal> animalsActual = AnimalUtilities.filter(animals, (String name) -> name.startsWith("l"));
		assertThat(animalsActual, is(animalsExpected));
	}

	@Test
	public final void testSwimmersFilter() {
		List<Animal> animalsExpected = Arrays.asList(new ArabianHorse("arabianHorse", "lucas", "2011"),
				new Duck("duck", "duck", "1999"));
		List<Animal> animalsActual = AnimalUtilities.swimmersFilter(animals,
				(Animal animal) -> animal instanceof Swimmer);

		assertThat(animalsActual, is(animalsExpected));
	}
}

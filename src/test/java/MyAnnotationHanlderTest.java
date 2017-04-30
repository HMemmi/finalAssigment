import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import se.kth.assigment.model.Animal;
import se.kth.assigment.model.ArabianHorse;
import se.kth.assigment.service.MyAnnotationHanlder;

public class MyAnnotationHanlderTest {

	private Animal animal;
	@Before
	public void setUp() throws Exception {
		animal= new ArabianHorse();
		animal.setName("horse");
		animal.setType("horse");
	}

	@Test
	public final void testFailHandleAnimal() {
		animal.setYear("204k");
	assertThat(MyAnnotationHanlder.handleAnimal(animal), is(false));
	}

	@Test
	public final void testTrueHandleAnimal() {
		animal.setYear("2010");
	assertThat(MyAnnotationHanlder.handleAnimal(animal), is(true));
	}
}

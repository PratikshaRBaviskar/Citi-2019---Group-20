package Sanction.screen;
import Validation.validation;
import static org.junit.Assert.*;
import org.junit.*;

public class validationtest {
private validation obj=null;

@Before
public void initiateTest() {
	obj=new validation();
}

@Test
public void checkAlphanumericAccnoTestCorrect() {
	assertEquals(true,obj.checkisValidAccno("1234567890ab"));
}

@Test
public void checkAlphanumericAccnoTestIncorrect() {
	assertEquals(false,obj.checkisValidAccno("123ab5"));
}

@Test
public void checkAlphanumericNameTestCorrect() {
	assertEquals(true,obj.checkisValidAccName("Absa1234"));
}
@Test
public void checkAlphanumericNameTestInCorrect() {
	assertEquals(false,obj.checkisValidAccName("ab-=][45cfg"));
}

@Test
public void checkDateFormatTestInCorrect() {
	assertEquals(false,obj.checkValidDate("34-[90jh")); //correct format
}
@Test
public void checkisValidAmount() {
	assertEquals(true,obj.checkisValidAmount(453648.789));
}

}

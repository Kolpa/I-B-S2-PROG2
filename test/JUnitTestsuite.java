import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ JUnitTestKochVO.class, JUnitTestKundeVO.class,
		JUnitTestPizzaVO.class, JUnitTestBestellung.class })
public class JUnitTestsuite {
}
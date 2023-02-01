package conditions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JREConditions {

	@Test
	@EnabledOnJre({ JRE.JAVA_8, JRE.JAVA_9 })
	public void testRunOnJRE8_9() {
		// more code
	}

	@Test
	@DisabledOnJre({ JRE.JAVA_11 })
	public void disabledOnJRE11() {
		// more code
	}

}

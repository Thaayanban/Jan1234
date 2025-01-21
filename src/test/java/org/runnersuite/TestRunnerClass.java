package org.runnersuite;

import org.execute.Tc01_AdactinHotelLoginPageValidation;
import org.execute.Tc02_AdactinHotelSearchHotelPageValidation;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	Tc01_AdactinHotelLoginPageValidation.class,
	Tc02_AdactinHotelSearchHotelPageValidation.class
	
	
})
public class TestRunnerClass {
	
	
	

}

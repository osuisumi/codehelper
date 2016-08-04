package base;

import com.isumi.freemaker.generater.DaoGenerater;
import com.isumi.freemaker.generater.EntityGenerater;
import com.isumi.freemaker.generater.MapperGenerater;
import com.isumi.freemaker.generater.ServiceGenerater;
import com.isumi.freemaker.generater.TestServiceGenerater;

public class Generate {

	public static void generateAll() {
		EntityGenerater.instance.generate();
		DaoGenerater.instance.generateAllDaoAndInterface();
		ServiceGenerater.instance.generateAll();
		MapperGenerater.instance.generate();
//		TestServiceGenerater.generate();
	}

}

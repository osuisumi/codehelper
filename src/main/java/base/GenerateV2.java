package base;

import com.isumi.freemaker.v2.DomainGenerater;
import com.isumi.freemaker.v2.MapperGenerater;
import com.isumi.freemaker.v2.ServiceGenerater;

public class GenerateV2 {
	
	public static void generateAll() {
		DomainGenerater.instance.generate();
		ServiceGenerater.instance.generateAll();
		MapperGenerater.instance.generate();
	}

}

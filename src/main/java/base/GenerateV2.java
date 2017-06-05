package base;

import com.isumi.freemaker.v2.ApplicationGenerater;
import com.isumi.freemaker.v2.ControllerGenerater;
import com.isumi.freemaker.v2.DockerFileGenerater;
import com.isumi.freemaker.v2.DomainGenerater;
import com.isumi.freemaker.v2.MapperGenerater;
import com.isumi.freemaker.v2.ServiceGenerater;
import com.isumi.freemaker.v2.SwaggerGenerater;
import com.isumi.freemaker.v2.XmlMapperGenerater;
import com.isumi.freemaker.v2.YmlApplicationGenerater;

public class GenerateV2 {
	
	public static void generateAll() {
		DomainGenerater.instance.generate();
		ServiceGenerater.instance.generateAll();
		MapperGenerater.instance.generate();
		XmlMapperGenerater.instance.generate();
		ControllerGenerater.instance.generate();
		ApplicationGenerater.instance.generate();
		DockerFileGenerater.instance.generate();
		SwaggerGenerater.instance.generate();
		YmlApplicationGenerater.instance.generate();
	}

}

package base;

import java.util.Arrays;

import com.isumi.config.EntityFactory;
import com.isumi.config.JDBCConnectionConfig;
import com.isumi.config.TableFactory;
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
	
	public GenerateV2(JDBCConnectionConfig jdbcConnectionConfig,String basePackage,String ... tables){
		EntityFactory.jdbcConnectionConfig = jdbcConnectionConfig;
		TableFactory.instance.basePackage = basePackage;
		TableFactory.instance.tableNames.addAll(Arrays.asList(tables));
	}
	
	public void generateAll() {
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

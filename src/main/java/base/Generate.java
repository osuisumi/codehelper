package base;

import java.util.Arrays;

import com.isumi.config.EntityFactory;
import com.isumi.config.JDBCConnectionConfig;
import com.isumi.config.TableFactory;
import com.isumi.freemaker.generater.DaoGenerater;
import com.isumi.freemaker.generater.EntityGenerater;
import com.isumi.freemaker.generater.MapperGenerater;
import com.isumi.freemaker.generater.ServiceGenerater;
public class Generate {
	
	
	
	public Generate(JDBCConnectionConfig jdbcConnectionConfig,String basePackage,String ... tables){
		EntityFactory.jdbcConnectionConfig = jdbcConnectionConfig;
		TableFactory.instance.basePackage = basePackage;
		TableFactory.instance.tableNames.addAll(Arrays.asList(tables));
	}

	public void generateAll() {
		EntityGenerater.instance.generate();
		DaoGenerater.instance.generateAllDaoAndInterface();
		ServiceGenerater.instance.generateAll();
		MapperGenerater.instance.generate();
	}

}

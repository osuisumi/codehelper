package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class Test1 extends Base{
	
	@Test
	public void testbase(){
		System.out.println(ac);
	}
	@Test
	public void testJdbcTemplate() throws SQLException, IOException{
		com.alibaba.druid.pool.DruidDataSource dataSource =  (DruidDataSource) ac.getBean("dataSource");
		DruidPooledConnection con = dataSource.getConnection();
		DatabaseMetaData metaData = con.getMetaData();
		
		Properties properties = new Properties();
		Reader reader = new FileReader(new File("table.property"));
		properties.load(reader);
		System.out.println(properties.getProperty("tableName"));;
		
//		metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
//		System.out.println(metaData);
	}
	

}

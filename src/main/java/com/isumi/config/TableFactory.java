package com.isumi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.isumi.entity.Table;
import com.isumi.entity.Table.Column;

public class TableFactory {
	
	
	public List<String> tableNames = new ArrayList<String>();
	
	public static TableFactory instance = new TableFactory();
	
	public String basePackage;
	
	public String getBasePackage(){
		return this.basePackage;
	}
	
	private TableFactory(){
//		File f = new File(this.getClass().getClassLoader().getResource("table.property").getFile());
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream(f);
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(e.getMessage());
//		}
//		Properties properties = new Properties();
//		try {
//			properties.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException(e.getMessage());
//		}
//		
//		String [] tables = properties.getProperty("table").split(",");
//		tableNames.addAll(Arrays.asList(tables));
//		this.basePackage = properties.getProperty("basePackage");
	}
	
	public List<Table> getTables(Connection connection) throws SQLException{
		
		List<Table> result = new ArrayList<Table>();
		try{
			DatabaseMetaData metaData = connection.getMetaData();
			for(String tableName:tableNames){
				ResultSet rs = metaData.getColumns(null,null,tableName, null);
				Table table = new Table();
				table.setName(tableName);
				while(rs.next()){
					Column c = new Column();
					c.setName(rs.getString("COLUMN_NAME"));
					c.setEnmu(rs.getInt("DATA_TYPE"));
					c.setType(JDBCType.valueOf(rs.getInt("DATA_TYPE")).toString());
					table.getColumns().add(c);
				}
				result.add(table);
				rs.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			connection.close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}

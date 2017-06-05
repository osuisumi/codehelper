package com.isumi.config;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isumi.StringUtils;
import com.isumi.db.ConnectionFactory;
import com.isumi.db.FullyQualifiedJavaType;
import com.isumi.db.JavaTypeResolver;
import com.isumi.entity.BaseEntityFields;
import com.isumi.entity.Entity;
import com.isumi.entity.Field;
import com.isumi.entity.Table;
import com.isumi.entity.Table.Column;

public class EntityFactory {
	
	public static EntityFactory instance = new EntityFactory();
	
	private EntityFactory(){}
	
	public static String getRootPath(){
		String classLoaderPath = instance.getClass().getClassLoader().getResource("applicationContext.xml").getPath();
		String result = classLoaderPath.replaceAll("target.+$", "");
		result = result + "/src/main/java/" +TableFactory.instance.getBasePackage().replaceAll("\\.", "/") ;
		File basePath = new File(result);
		if(!basePath.exists()){
			basePath.mkdirs();
		}
		return result;
	}
	
	public static String getResourceRootPath(){
		String classLoaderPath = instance.getClass().getClassLoader().getResource("applicationContext.xml").getPath();
		String result = classLoaderPath.replaceAll("target.+$", "");
		result = result + "/src/main/resources";
		File resourceRoot = new File(result);
		if(!resourceRoot.exists()){
			resourceRoot.mkdirs();
		}
		return result;
	}
	
	private static List<Entity> getEntity(List<Table> tables){
		List<Entity> result = new ArrayList<Entity>();
		for(Table tb:tables){
			Entity entity = new Entity();
			entity.setName(StringUtils.getEntityNameFromTableName(tb.getName()));
			entity.setBasePackage(TableFactory.instance.getBasePackage());
			entity.setRelativeTable(tb);
			//开始处理字段
			for(Column c:tb.getColumns()){
				if(!BaseEntityFields.isBaseEntityField(StringUtils.getFieldNameFromColumnName(c.getName()))){
					FullyQualifiedJavaType javaType = JavaTypeResolver.instance.getJavaTypeInfo(c.getEnmu());
					Field field = new Field();
					field.setType(javaType.getSimpleName());
					field.setName(StringUtils.getFieldNameFromColumnName(c.getName()));
					field.setRelativeColumn(c);
					entity.getFields().add(field);
					if(!javaType.getFullName().contains("java.lang")){
						entity.getImportPackages().add(javaType.getFullName());
					}
				}
			}
			result.add(entity);
		}
		return result;
	}
	
	public static List<Entity> getEntity(){
		try {
			return instance.getEntity(TableFactory.instance.getTables(ConnectionFactory.getInstance().getConnection(JDBCConnectionConfig.getDefaultInstance())));
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	

}

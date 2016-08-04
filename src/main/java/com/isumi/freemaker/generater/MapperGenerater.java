package com.isumi.freemaker.generater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isumi.config.EntityFactory;
import com.isumi.entity.Entity;
import com.isumi.freemaker.TemplateFactory;

import freemarker.template.Template;

public class MapperGenerater {
	
	private MapperGenerater(){}
	
	public static MapperGenerater instance = new MapperGenerater();
	
	public void generate(List<Entity> entitys){
		Template entityTemplate = TemplateFactory.getTemplate("mapper.ftl");
		for(Entity entity:entitys){
			try {
				File mapperFolder = new File(EntityFactory.getRootPath() + "/dao/impl/mybatis");
				if(!mapperFolder.exists()){
					mapperFolder.mkdirs();
				}
				FileOutputStream fos = new  FileOutputStream(EntityFactory.getRootPath() + "/dao/impl/mybatis/"+entity.getName()+"Mapper.xml");   
				Map data = new  HashMap();
				data.put("entity",entity);
				entityTemplate.process(data, new OutputStreamWriter(fos, "utf-8" ));
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void generate(){
		generate(EntityFactory.getEntity());
	}

}

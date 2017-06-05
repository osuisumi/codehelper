package com.isumi.freemaker.v2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isumi.config.EntityFactory;
import com.isumi.entity.Entity;
import com.isumi.freemaker.TemplateFactory;

import freemarker.template.Template;

public class MapperGenerater {
	
	public static MapperGenerater instance = new MapperGenerater();

	private MapperGenerater() {
	}

	public void generate(List<Entity> entitys) {
		Template entityTemplate = TemplateFactory.getTemplatev2("Mapper.ftl");
		for (Entity entity : entitys) {
			try {
				File entityFolder = new File(EntityFactory.getRootPath()+"/mapper");
				if(!entityFolder.exists()){
					entityFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(new File(EntityFactory.getRootPath()+"/mapper/"+entity.getName()+"Mapper.java"));// java文件的生成目录
				Map data = new HashMap();
				data.put("entity", entity);
				entityTemplate.process(data, new OutputStreamWriter(fos, "utf-8"));
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void generate(){
		instance.generate(EntityFactory.getEntity());
	}
	

	public static void main(String[] args) throws SQLException {
		instance.generate(EntityFactory.getEntity());
	}

}

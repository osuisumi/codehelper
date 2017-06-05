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

public class ServiceGenerater {
	public static ServiceGenerater instance = new ServiceGenerater();

	private ServiceGenerater() {
	}

	public void generateInterface(List<Entity> entitys) {
		Template entityTemplate = TemplateFactory.getTemplatev2("IService.ftl");
		for (Entity entity : entitys) {
			try {
				File IServiceFolder = new File(EntityFactory.getRootPath() + "/service");
				if(!IServiceFolder.exists()){
					IServiceFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(EntityFactory.getRootPath() + "/service/I"+entity.getName()+"Service.java");// java文件的生成目录
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

	public void generate(List<Entity> entitys) {
		Template entityTemplate = TemplateFactory.getTemplatev2("Service.ftl");
		for (Entity entity : entitys) {
			try {
				File ServiceFolder = new File(EntityFactory.getRootPath() + "/service/impl");
				if(!ServiceFolder.exists()){
					ServiceFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(EntityFactory.getRootPath() + "/service/impl/"+entity.getName()+"Service.java");// java文件的生成目录
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
		generate(EntityFactory.getEntity());
	}
	
	public void generateInterface(){
		generateInterface(EntityFactory.getEntity());
	}
	
	public void generateAll(){
		generate();
		generateInterface();
	}

	public static void main(String[] args) throws SQLException {
		instance.generateInterface(EntityFactory.getEntity());
	}

}

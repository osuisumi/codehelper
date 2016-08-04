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

public class TestServiceGenerater {
	
	public static void  generate(List<Entity> entitys){
		Template entityTemplate = TemplateFactory.getTemplate("TestService.ftl");
		for (Entity entity : entitys) {
			try {
				File IServiceFolder = new File(EntityFactory.getRootPath() + "/service");
				if(!IServiceFolder.exists()){
					IServiceFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(EntityFactory.getRootPath() + "/service/Test"+entity.getName()+"Service.java");// java文件的生成目录
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
	
	public static void generate(){
		generate(EntityFactory.getEntity());
	}
	

}

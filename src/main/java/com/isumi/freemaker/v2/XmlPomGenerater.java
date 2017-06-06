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

public class XmlPomGenerater {
	public static XmlPomGenerater instance = new XmlPomGenerater();

	private XmlPomGenerater() {
	}

	public void generate(List<Entity> entitys) {
		Template entityTemplate = TemplateFactory.getTemplatev2("XmlPom.ftl");
		for (Entity entity : entitys) {
			try {
				FileOutputStream fos = new FileOutputStream(new File(EntityFactory.getProjectRootPath() + "/"+entity.getName()+"pom.xml"));// java文件的生成目录
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

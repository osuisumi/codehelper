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

public class DaoGenerater {

	public static DaoGenerater instance = new DaoGenerater();

	private DaoGenerater() {
	}

	public static void generateInterface(List<Entity> entitys) {
		Template entityTemplate = TemplateFactory.getTemplate("IDao.ftl");
		for (Entity entity : entitys) {
			try {
				File IdaoFolder = new File(EntityFactory.getRootPath() + "/dao");
				if(!IdaoFolder.exists()){
					IdaoFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(new File(EntityFactory.getRootPath()+"/dao/I"+entity.getName()+"Dao.java"));// java文件的生成目录
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
		Template entityTemplate = TemplateFactory.getTemplate("Dao.ftl");
		for (Entity entity : entitys) {
			try {
				File daoFolder = new File(EntityFactory.getRootPath() + "/dao/impl/mybatis");
				if(!daoFolder.exists()){
					daoFolder.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(EntityFactory.getRootPath() + "/dao/impl/mybatis/"+entity.getName()+"Dao.java");// java文件的生成目录
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

	public void generate() {
		instance.generate(EntityFactory.getEntity());
	}

	public void generateInterface() {
		instance.generateInterface(EntityFactory.getEntity());
	}

	public void generateAllDaoAndInterface() {
		generate();
		generateInterface();
	}

	public static void main(String[] args) {
		instance.generateAllDaoAndInterface();
	}

}

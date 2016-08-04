package com.isumi.freemaker;

import java.io.IOException;

import com.isumi.freemaker.generater.EntityGenerater;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class TemplateFactory {
	
	public static TemplateFactory instance = new TemplateFactory();
	
	private TemplateFactory(){}
	
	public static Template getTemplate(String name){
		Configuration cfg = new  Configuration();
        cfg.setClassForTemplateLoading(EntityGenerater.class ,  "/com/isumi/ftl" ); //指定模板所在的classpath目录   
//        cfg.setSharedVariable("upperFC" ,  new  UpperFirstWord()); //添加一个"宏"共享变量用来将属性名首字母大写   
        try {
			Template t = cfg.getTemplate(name); //指定模板   
			return t;
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	
}

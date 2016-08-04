package ${entity.basePackage}.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Maps;
import com.haoyu.sip.core.service.Response;
import com.isumi.entity.${entity.name};
import com.isumi.service.I${entity.name}Service;

public class Test${entity.name}Service {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private static I${entity.name}Service ${entity.name?uncap_first}Service = (I${entity.name}Service) ac.getBean("${entity.name?uncap_first}Service");
	
	public static void testInsert(){
		${entity.name} ${entity.name?uncap_first} = generate${entity.name}();
		${entity.name?uncap_first}.setId("test1");
		Response response = ${entity.name?uncap_first}Service.create${entity.name}(${entity.name?uncap_first});
		if(response.isSuccess()){
			System.out.println("testInsert success");
		}else{
			System.out.println("testInsert fail");
		}
	}
	
	public static void testGet(){
		${entity.name} ${entity.name?uncap_first} = ${entity.name?uncap_first}Service.find${entity.name}ById("test1");
		if(${entity.name?uncap_first} != null){
			System.out.println("testGet success");
		}else{
			System.out.println("testGet fail");
		}
	}
	
	public static void testList(){
		List<${entity.name}> ${entity.name?uncap_first}s = ${entity.name?uncap_first}Service.find${entity.name}s(Maps.newHashMap(), null);
		if(!CollectionUtils.isEmpty(${entity.name?uncap_first}s)){
			System.out.println("testList success");
		}else{
			System.out.println("testList fail");
		}
	}
	
	
	
	public static void main(String[] args) {
		testInsert();
		testGet();
		testList();
	}
	
	public static ${entity.name} generate${entity.name}(){
		${entity.name} ${entity.name?uncap_first} = new ${entity.name}();
		Field [] fields  = ${entity.name?uncap_first}.getClass().getDeclaredFields();
		for(Field field:fields){
			String type = field.getType().toString().toLowerCase();
			field.setAccessible(true);
			try{
				if(type.indexOf("string")>=0){
					field.set(${entity.name?uncap_first}, RandomString(3));
				}else if(type.indexOf("int")>=0){
					field.set(${entity.name?uncap_first},RandomUtils.nextInt(0, 999) );
				}else if(type.indexOf("date")>=0){
					field.set(${entity.name?uncap_first},new Date());
				}else if(type.indexOf("long")>=0){
					field.set(${entity.name?uncap_first}, RandomUtils.nextLong(0l, 999l));;
				}else if(type.indexOf("float")>=0){
					field.set(${entity.name?uncap_first}, RandomUtils.nextFloat(0f, 999f));
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		return ${entity.name?uncap_first};
	}
	
	
	
	public static String RandomString(int bit){
		if (bit == 0)
			bit = 6; // 默认6位
		// 因为o和0,l和1很难区分,所以,去掉大小写的o和l
		String str = "";
		str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
		return RandomStringUtils.random(bit, str);// 返回6位的字符串
	}
	

}

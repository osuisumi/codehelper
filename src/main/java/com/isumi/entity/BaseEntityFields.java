package com.isumi.entity;


public class BaseEntityFields {
	
	private static String [] baseEntityField ={"creator","updatedby","createTime","updateTime","isDeleted","version"};
	
	public static boolean isBaseEntityField(String name){
		for(String n:baseEntityField){
			if(n.equals(name)){
				return true;
			}
		}
		return false;
		
	}

}

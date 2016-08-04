package com.isumi;

public class StringUtils {
	
	public static String getEntityNameFromTableName(String tableName){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<tableName.length();i++){
			if('_'!=(tableName.charAt(i))){
				if(i==0){
					sb.append(String.valueOf(tableName.charAt(i)).toUpperCase());
				}
				else if(i > 0&&'_'==(tableName.charAt(i-1))){
					sb.append(String.valueOf(tableName.charAt(i)).toUpperCase());
				}else{
					sb.append(String.valueOf(tableName.charAt(i)).toLowerCase());
				}
			}
		}
		return sb.toString();
	}
	
	public static String getFieldNameFromColumnName(String columnName){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<columnName.length();i++){
			if('_'!=(columnName.charAt(i))){
				if(i > 0&&'_'==(columnName.charAt(i-1))){
					sb.append(String.valueOf(columnName.charAt(i)).toUpperCase());
				}else{
					sb.append(String.valueOf(columnName.charAt(i)).toLowerCase());
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getEntityNameFromTableName("POINT_RECORD"));
		System.out.println(getFieldNameFromColumnName("POINT_RECORD"));
	}
	

}

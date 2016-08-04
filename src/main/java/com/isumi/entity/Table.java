package com.isumi.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class Table {

	private String name;

	private List<Column> columns = new ArrayList<Column>();
	
	private String simpleName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	public String getSimpleName(){
		if(StringUtils.isEmpty(this.simpleName)){
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i<this.name.length();i++){
				if(i == 0|| '_' == this.name.charAt(i-1)){
					sb.append(String.valueOf(this.name.charAt(i)).toUpperCase());
				}
			}
			this.simpleName = sb.toString();
		}
		return this.simpleName;
	}

	public static class Column {
		private String type;

		private String name;
		
		private Integer enmu;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getEnmu() {
			return enmu;
		}

		public void setEnmu(Integer enmu) {
			this.enmu = enmu;
		}
		
		

	}

}

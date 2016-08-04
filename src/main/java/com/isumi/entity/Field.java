package com.isumi.entity;

import com.isumi.entity.Table.Column;

public class Field {

	private String name;

	private String type;

	private Column relativeColumn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Column getRelativeColumn() {
		return relativeColumn;
	}

	public void setRelativeColumn(Column relativeColumn) {
		this.relativeColumn = relativeColumn;
	}

}

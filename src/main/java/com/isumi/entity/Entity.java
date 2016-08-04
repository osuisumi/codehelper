package com.isumi.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Entity {

	private String name;

	private String basePackage;

	private Set<String> importPackages = new HashSet<String>();

	private List<Field> fields = new ArrayList<Field>();

	private Table relativeTable;

	public Table getRelativeTable() {
		return relativeTable;
	}

	public void setRelativeTable(Table relativeTable) {
		this.relativeTable = relativeTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public Set<String> getImportPackages() {
		return importPackages;
	}

	public void setImportPackages(Set<String> importPackages) {
		this.importPackages = importPackages;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}

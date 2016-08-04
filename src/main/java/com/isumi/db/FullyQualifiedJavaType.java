package com.isumi.db;

public class FullyQualifiedJavaType {
	private String fullName;

	private String simpleName;

	public FullyQualifiedJavaType(String fullName) {
		
		this.fullName = fullName;
		
		this.simpleName = fullName.substring(fullName.lastIndexOf(".")+1);

	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

}

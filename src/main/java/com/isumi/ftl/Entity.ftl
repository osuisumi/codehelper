package ${entity.basePackage}.entity;
import com.haoyu.sip.core.entity.BaseEntity;
<#if entity.importPackages??>
	<#list entity.importPackages as ip>
import ${ip};
	</#list>
</#if>

public class ${entity.name} extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	<#if entity.fields??>
		<#list entity.fields as field>
			private	${field.type}	${field.name};
		</#list>
	</#if>
	
	
	<#if entity.fields??>
		<#list entity.fields as field>
			public ${field.type} get${field.name?cap_first}(){
				return ${field.name};
			}
			
			public void set${field.name?cap_first}(${field.type} ${field.name}){
				this.${field.name} = ${field.name};
			}
		</#list>
	</#if>
	
	

}

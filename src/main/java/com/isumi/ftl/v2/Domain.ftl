package ${entity.basePackage}.domain;

import java.io.Serializable;
import javax.persistence.Transient;
import com.haoyu.sip.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

<#if entity.importPackages??>
	<#list entity.importPackages as ip>
import ${ip};
	</#list>
</#if>



@ApiModel(value = "${entity.name}", description = "")
public class ${entity.name} extends BaseEntity<String> implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	<#if entity.fields??>
		<#list entity.fields as field>
	@ApiModelProperty(value = "")
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
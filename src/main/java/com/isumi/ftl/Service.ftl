package ${entity.basePackage}.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.common.collect.Maps;
import com.haoyu.sip.core.service.Response;
import com.haoyu.sip.utils.Identities;
import ${entity.basePackage}.dao.I${entity.name}Dao;
import ${entity.basePackage}.entity.${entity.name};
import ${entity.basePackage}.service.I${entity.name}Service;

@Service
public class ${entity.name}Service implements I${entity.name}Service{
	@Resource
	private I${entity.name}Dao ${entity.name?cap_first}Dao;

	@Override
	public Response create${entity.name}(${entity.name} ${entity.name?cap_first}) {
		if(StringUtils.isEmpty(${entity.name?cap_first}.getId())){
			${entity.name?cap_first}.setId(Identities.uuid2());
		}
		${entity.name?cap_first}.setDefaultValue();
		return ${entity.name?cap_first}Dao.insert${entity.name}(${entity.name?cap_first})>0?Response.successInstance():Response.failInstance();
	}

	@Override
	public Response update${entity.name}(${entity.name} ${entity.name?cap_first}) {
		${entity.name?cap_first}.setUpdateValue();
		return ${entity.name?cap_first}Dao.update${entity.name}(${entity.name?cap_first})>0?Response.successInstance():Response.failInstance();
	}

	@Override
	public Response delete${entity.name}(${entity.name} ${entity.name?cap_first}) {
		${entity.name?cap_first}.setUpdateValue();
		return ${entity.name?cap_first}Dao.delete${entity.name}ByLogic(${entity.name?cap_first})>0?Response.successInstance():Response.failInstance();
	}

	@Override
	public ${entity.name} find${entity.name}ById(String id) {
		return ${entity.name?cap_first}Dao.select${entity.name}ById(id);
	}

	@Override
	public List<${entity.name}> find${entity.name}s(${entity.name} ${entity.name?cap_first}, PageBounds pageBounds) {
		Map<String,Object> parameter = Maps.newHashMap();
		return ${entity.name?cap_first}Dao.findAll(parameter, pageBounds);
	}

	@Override
	public List<${entity.name}> find${entity.name}s(Map<String, Object> parameter, PageBounds pageBounds) {
		return ${entity.name?cap_first}Dao.findAll(parameter, pageBounds);
	}

}

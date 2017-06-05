package ${entity.basePackage}.service;

import java.util.List;

import ${entity.basePackage}.domain.${entity.name};

public interface I${entity.name}Service {
	
	int create(${entity.name} ${entity.name?uncap_first});
	
	int update(${entity.name} ${entity.name?uncap_first});
	
	int deletePhysicsById(String id);
	
	${entity.name} findById(String id);
	
	List<${entity.name}> findByEntity(${entity.name} ${entity.name?uncap_first});

}

package ${entity.basePackage}.service;

import java.util.List;

import com.haoyu.sip.datadict.domain.${entity.name};

public interface I${entity.name}Service {
	
	int create(${entity.name} ${entity.name?uncap_first});
	
	int update(${entity.name} ${entity.name?uncap_first});
	
	int deletePhysicsById(String id);
	
	${entity.name} findById(String id);
	
	List<${entity.name}> findByEntity(${entity.name} ${entity.name?uncap_first});

}

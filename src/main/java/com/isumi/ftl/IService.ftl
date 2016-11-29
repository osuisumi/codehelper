package ${entity.basePackage}.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${entity.basePackage}.entity.${entity.name};
import com.haoyu.sip.core.service.Response;

public interface I${entity.name}Service {
	
	Response create${entity.name}(${entity.name} ${entity.name?uncap_first});
	
	Response update${entity.name}(${entity.name} ${entity.name?uncap_first});
	
	Response delete${entity.name}(${entity.name} ${entity.name?uncap_first});
	
	${entity.name} find${entity.name}ById(String id);
	
	List<${entity.name}> find${entity.name}s(${entity.name} ${entity.name?uncap_first},PageBounds pageBounds);
	
	List<${entity.name}> find${entity.name}s(Map<String,Object> parameter,PageBounds pageBounds);
}

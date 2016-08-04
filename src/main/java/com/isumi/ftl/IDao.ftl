package ${entity.basePackage}.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${entity.basePackage}.entity.${entity.name};

public interface I${entity.name}Dao {

	${entity.name} select${entity.name}ById(String id);

	int insert${entity.name}(${entity.name} ${entity.name?cap_first});

	int update${entity.name}(${entity.name} ${entity.name?cap_first});

	int delete${entity.name}ByLogic(${entity.name} ${entity.name?cap_first});

	int delete${entity.name}ByPhysics(String id);

	List<${entity.name}> findAll(Map<String, Object> parameter);

	List<${entity.name}> findAll(Map<String, Object> parameter, PageBounds pageBounds);

}
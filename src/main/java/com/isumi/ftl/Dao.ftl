package ${entity.basePackage}.dao.impl.mybatis;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${entity.basePackage}.dao.I${entity.name}Dao;
import ${entity.basePackage}.entity.${entity.name};
import com.haoyu.sip.core.jdbc.MybatisDao;

@Repository
public class ${entity.name}Dao extends MybatisDao implements I${entity.name}Dao {

	@Override
	public ${entity.name} select${entity.name}ById(String id) {
		return super.selectByPrimaryKey(id);
	}

	@Override
	public int insert${entity.name}(${entity.name} ${entity.name?uncap_first}) {
		${entity.name?uncap_first}.setDefaultValue();
		return super.insert(${entity.name?uncap_first});
	}

	@Override
	public int update${entity.name}(${entity.name} ${entity.name?uncap_first}) {
		${entity.name?uncap_first}.setUpdateValue();
		return super.update(${entity.name?uncap_first});
	}

	@Override
	public int delete${entity.name}ByLogic(${entity.name} ${entity.name?uncap_first}) {
		${entity.name?uncap_first}.setUpdateValue();
		return super.deleteByLogic(${entity.name?uncap_first});
	}

	@Override
	public int delete${entity.name}ByPhysics(String id) {
		return super.deleteByPhysics(id);
	}

	@Override
	public List<${entity.name}> findAll(Map<String, Object> parameter) {
		return super.selectList("selectByParameter", parameter);
	}

	@Override
	public List<${entity.name}> findAll(Map<String, Object> parameter, PageBounds pageBounds) {
		return super.selectList("selectByParameter", parameter, pageBounds);
	}

	
}

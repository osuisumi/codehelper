package ${entity.basePackage}.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ${entity.basePackage}.entity.${entity.name};
import ${entity.basePackage}.service.I${entity.name}Service;
import com.haoyu.sip.service.BaseService;

@Service
public class ${entity.name}Service extends BaseService<${entity.name}, String> implements I${entity.name}Service{


}
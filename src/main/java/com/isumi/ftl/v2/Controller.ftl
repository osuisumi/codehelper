package ${entity.basePackage}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haoyu.sip.controller.BaseRestController;
import ${entity.basePackage}.domain.${entity.name};
import ${entity.basePackage}.service.I${entity.name}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RefreshScope
@Api(tags={"${entity.name}rest接口"})
@RestController
@RequestMapping("/v1/${entity.name}")
public class ${entity.name}Controller extends BaseRestController<${entity.name}, String>{
	
	@Autowired
	private I${entity.name}Service ${entity.name?uncap_first}Service;

}

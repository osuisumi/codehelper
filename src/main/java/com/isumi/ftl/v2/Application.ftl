package ${entity.basePackage};

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;



@MapperScan("${entity.basePackage}.mapper*")
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
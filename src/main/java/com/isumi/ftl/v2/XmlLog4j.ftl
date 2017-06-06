<?xml version="1.0" encoding="utf-8"?>
<configuration>
	<properties>
		<!-- 文件输出格式 -->
		<property name="PATTERN">%d{yyyy-MM-dd HH:mm:ss.SSS} |-%-5level [%thread] %c [%L] -| %msg%n</property>
	</properties>

	<appenders>
		<Console name="CONSOLE" target="system_out">
			<PatternLayout pattern="${r'${PATTERN}'}" />
		</Console>
	</appenders>
	
	<loggers>
		<logger name="${r'${entity.basePackage}'}.mapper" level="debug" />
		<logger name="com.haoyu" level="debug" />
		<root level="info">
			<appenderref ref="CONSOLE" />
		</root>
	</loggers>

</configuration>
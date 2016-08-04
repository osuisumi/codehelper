<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entity.basePackage}.dao.impl.mybatis.${entity.name}Mapper">
	<resultMap id="BaseResultMap" type="${entity.basePackage}.entity.${entity.name}">
	<id column="ID" property="id" jdbcType="VARCHAR" />
		<#if entity.fields??>
			<#list entity.fields as field>
				<#if field.name != 'id'>
	<result column="${field.relativeColumn.name}" property="${field.name}" jdbcType="${field.relativeColumn.type}"/>
				</#if>
			</#list>
		</#if>
	<result column="CREATOR" property="creator.id" jdbcType="VARCHAR"/>
	<result column="CREATE_TIME" property="createTime" jdbcType="VARCHAR"/>
	</resultMap>
	
	<sql id="Base_Column_List">
		<#if entity.fields??>
			<#list entity.fields as field>${entity.relativeTable.simpleName}.${field.relativeColumn.name},</#list>${entity.relativeTable.simpleName}.CREATE_TIME,${entity.relativeTable.simpleName}.CREATOR
		</#if>
	</sql>
	
	<select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.String">
		select	<include refid="Base_Column_List" />
		from ${entity.relativeTable.name} ${entity.relativeTable.simpleName}
		where ${entity.relativeTable.simpleName}.IS_DELETED = 'N'
		and ${entity.relativeTable.simpleName}.ID = ${r'#'}{id,jdbcType=VARCHAR}
	</select>
	
	<select id="selectByParameter" parameterType="java.util.Map" resultMap="BaseResultMap">
		select <include refid="Base_Column_List" />
		from ${entity.relativeTable.name} ${entity.relativeTable.simpleName}
		where ${entity.relativeTable.simpleName}.IS_DELETED = 'N'
	</select>
	
	<insert id="insert" parameterType="${entity.basePackage}.entity.${entity.name}">
		insert into ${entity.relativeTable.name}
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<#if entity.fields??>
				<#list entity.fields as field>
			<if test="${field.name} != null">${field.relativeColumn.name},</if>
				</#list>
			</#if>
			<if test="creator != null and creator.id != null">CREATOR,</if>
			<if test="createTime != null">CREATE_TIME,</if>
			<if test="version != null">VERSION,</if>
			<if test="isDeleted != null">IS_DELETED,</if>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<#if entity.fields??>
				<#list entity.fields as field>
			<if test="${field.name} != null">${r'#'}{${field.name},jdbcType=${field.relativeColumn.type}},</if>
				</#list>
			</#if>
			<if test="creator != null and creator.id != null">${r'#'}{creator.id,jdbcType=VARCHAR},</if>
			<if test="createTime != null">${r'#'}{createTime,jdbcType=VARCHAR},</if>
			<if test="version != null">${r'#'}{version,jdbcType=DECIMAL},</if>
			<if test="isDeleted != null">${r'#'}{isDeleted,jdbcType=VARCHAR},</if>
		</trim>
	</insert>
	<update id="updateByPrimaryKey" parameterType="${entity.basePackage}.entity.${entity.name}">
	</update>
	<update id="deleteByLogic" parameterType="${entity.basePackage}.entity.${entity.name}">
	</update>
</mapper>
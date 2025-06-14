<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#if prefix == "*">
<mapper namespace="${packageName}.mapper.${classInfo.className}Mapper">
<#else>
<mapper namespace="${packageName}.${prefix}.mapper.${classInfo.className}Mapper">
</#if>

</mapper>
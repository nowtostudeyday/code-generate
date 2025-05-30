<#if prefix == "*">
package ${packageName}.base.${classInfo.modelName}.mapper;
<#else>
package ${packageName}.base.${prefix}.${classInfo.modelName}.mapper;
</#if>

import ${packageName}.base.base.GwallBaseMapper;
<#if prefix == "*">
import ${packageName}.base.${classInfo.modelName}.entity.${classInfo.className};
<#else>
import ${packageName}.base.${prefix}.${classInfo.modelName}.entity.${classInfo.className};
</#if>
import org.apache.ibatis.annotations.Mapper;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')} Mapper
* @Version: 1.0
*/
@Mapper
public interface ${classInfo.className}Mapper extends GwallBaseMapper<${classInfo.className}> {

}

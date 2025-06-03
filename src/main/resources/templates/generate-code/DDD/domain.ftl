<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.domain;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.domain;
</#if>

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}领域层
* @Version: 1.0
*/
public interface ${classInfo.className}DomainService {
}

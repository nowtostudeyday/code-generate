<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.scene;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.scene;
</#if>

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}场景层
* @Version: 1.0
*/
public interface ${classInfo.className}SceneService {

}
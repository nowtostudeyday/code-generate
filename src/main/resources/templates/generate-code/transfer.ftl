<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.transfer;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.transfer;
</#if>

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description:
* @Version: 1.0
*/
public class ${classInfo.className}Transfer {
}

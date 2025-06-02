<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.transfer;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.transfer;
</#if>

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description:
* @Version: 1.0
*/
public interface ${classInfo.className}Transfer {

    ${classInfo.className}Transfer INSTANCE = Mappers.getMapper(${classInfo.className}Transfer.class);

}

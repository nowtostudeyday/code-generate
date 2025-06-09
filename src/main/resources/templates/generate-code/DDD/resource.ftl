<#if prefix == "*">
package ${packageName}.base.${classInfo.modelName}.repository;
<#else>
package ${packageName}.base.${prefix}.${classInfo.modelName}.repository;
</#if>

<#if prefix == "*">
import ${packageName}.base.${classInfo.modelName}.mapper.${classInfo.className}Mapper;
<#else>
import ${packageName}.base.${prefix}.${classInfo.modelName}.mapper.${classInfo.className}Mapper;
</#if>
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}资源层
* @Version: 1.0
*/
@Service
public class ${classInfo.className}ResourceService {

    @Resource
    private ${classInfo.className}Mapper ${classInfo.modelName}Mapper;


}

<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.domain;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.domain;
</#if>

<#if prefix == "*">
import ${packageName}.base.${classInfo.modelName}.repository.${classInfo.className}ResourceService;
<#else>
import ${packageName}.base.${prefix}.${classInfo.modelName}.repository.${classInfo.className}ResourceService;
</#if>
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}领域实现
* @Version: 1.0
*/
@Slf4j
@Service
public class ${classInfo.className}DomainServiceImpl implements ${classInfo.className}DomainService {

    @Resource
    private ${classInfo.className}ResourceService ${classInfo.modelName}ResourceService;

}

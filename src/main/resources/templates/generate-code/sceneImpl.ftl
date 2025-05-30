<#if prefix == "*">
package ${packageName}.core.${classInfo.modelName}.scene;
<#else>
package ${packageName}.core.${prefix}.${classInfo.modelName}.scene;
</#if>

<#if prefix == "*">
import ${packageName}.core.${classInfo.modelName}.domain.${classInfo.className}DomainService;
<#else>
import ${packageName}.core.${prefix}.${classInfo.modelName}.domain.${classInfo.className}DomainService;
</#if>
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}场景层实现
* @Version: 1.0
*/
@Slf4j
@Service
public class ${classInfo.className}SceneServiceImpl implements ${classInfo.className}SceneService {

    @Resource
    private ${classInfo.className}DomainService ${classInfo.modelName}DomainService;

}

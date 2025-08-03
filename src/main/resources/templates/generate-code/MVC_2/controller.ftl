<#if prefix == "*">
package ${packageName}.controller;

import ${packageName}.service.${classInfo.className}Service;
<#else>
package ${packageName}.${prefix}.controller;

import ${packageName}.${prefix}.service.${classInfo.className}Service;
</#if>
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}控制层
* @Version: 1.0
*/
@RestController
@RequestMapping(value = "/api/v1/${classInfo.modelName}")
public class ${classInfo.className}Controller {

    @Autowired
    private ${classInfo.className}Service ${classInfo.modelName}Service;

}

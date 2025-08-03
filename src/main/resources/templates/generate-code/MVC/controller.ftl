<#if prefix == "*">
package ${packageName}.${classInfo.modelName}.controller;

import ${packageName}.${classInfo.modelName}.service.${classInfo.className}Service;
<#else>
package ${packageName}.${prefix}.${classInfo.modelName}.controller;

import ${packageName}.${prefix}.${classInfo.modelName}.service.${classInfo.className}Service;
</#if>
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}控制层
* @Version: 1.0
*/
@Controller
@RequestMapping(value = "/api/v1/${classInfo.modelName}")
public class ${classInfo.className}Controller {

    @Autowired
    private ${classInfo.className}Service ${classInfo.modelName}Service;

}

<#if prefix == "*">
package ${packageName}.controller;

import ${packageName}.service.${classInfo.className}Service;
<#else>
package ${packageName}.${prefix}.controller;

import ${packageName}.${prefix}.service.${classInfo.className}Service;
</#if>
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

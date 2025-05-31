<#if prefix == "*">
package ${packageName}.web.${classInfo.modelName};

import ${packageName}.core.${classInfo.modelName}.scene.${classInfo.className}SceneService;
<#else>
package ${packageName}.web.${prefix}.${classInfo.modelName};

import ${packageName}.core.${prefix}.${classInfo.modelName}.scene.${classInfo.className}SceneService;
</#if>
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}控制层
* @Version: 1.0
*/
@RestController
@RequestMapping(value = "/api/v1/${classInfo.modelName}")
@Api(tags = "${classInfo.classComment?replace('表$', '')}")
public class ${classInfo.className}Controller {

    @Resource
    private ${classInfo.className}SceneService ${classInfo.modelName}SceneService;

}

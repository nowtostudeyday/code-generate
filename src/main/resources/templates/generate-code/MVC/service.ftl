<#if prefix == "*">
package ${packageName}.${classInfo.modelName}.service;

import ${packageName}.${classInfo.modelName}.entity.${classInfo.className};
<#else>
package ${packageName}.${prefix}.${classInfo.modelName}.service;

import ${packageName}.${prefix}.${classInfo.modelName}.entity.${classInfo.className};
</#if>
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}业务层
* @Version: 1.0
*/
public interface ${classInfo.className}Service extends IService<${classInfo.className}> {

}

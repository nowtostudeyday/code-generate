<#if prefix == "*">
package ${packageName}.service;

import ${packageName}.entity.${classInfo.className};
<#else>
package ${packageName}.${prefix}.service;

import ${packageName}.${prefix}.entity.${classInfo.className};
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

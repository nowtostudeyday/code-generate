<#if prefix == "*">
package ${packageName}.service.impl;

import ${packageName}.entity.${classInfo.className};
import ${packageName}.mapper.${classInfo.className}Mapper;
import ${packageName}.service.${classInfo.className}Service;
<#else>
package ${packageName}.${prefix}.service.impl;

import ${packageName}.${prefix}.entity.${classInfo.className};
import ${packageName}.${prefix}.mapper.${classInfo.className}Mapper;
import ${packageName}.${prefix}.service.${classInfo.className}Service;
</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}业务实现类
* @Version: 1.0
*/
@Service
public class ${classInfo.className}ServiceImpl extends ServiceImpl<${classInfo.className}Mapper, ${classInfo.className}> implements ${classInfo.className}Service {

    @Autowired
	private ${classInfo.className}Mapper ${classInfo.modelName}Mapper;

}
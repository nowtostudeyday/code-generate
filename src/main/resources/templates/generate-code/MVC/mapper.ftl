<#if prefix == "*">
package ${packageName}.${classInfo.modelName}.mapper;

import ${packageName}.${classInfo.modelName}.entity.${classInfo.className};
<#else>
package ${packageName}.${prefix}.${classInfo.modelName}.mapper;

import ${packageName}.${prefix}.${classInfo.modelName}.entity.${classInfo.className};
</#if>
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')} Mapper
* @Version: 1.0
*/
@Mapper
public interface ${classInfo.className}Mapper extends BaseMapper<${classInfo.className}> {

}

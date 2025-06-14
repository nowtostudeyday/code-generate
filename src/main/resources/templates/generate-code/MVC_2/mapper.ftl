<#if prefix == "*">
package ${packageName}.mapper;

import ${packageName}.entity.${classInfo.className};
<#else>
package ${packageName}.${prefix}.mapper;

import ${packageName}.${prefix}.entity.${classInfo.className};
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

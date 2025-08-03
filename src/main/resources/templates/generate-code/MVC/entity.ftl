<#if prefix == "*">
package ${packageName}.${classInfo.modelName}.entity;
<#else>
package ${packageName}.${prefix}.${classInfo.modelName}.entity;
</#if>

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment?replace('表$', '')}实体类
* @Version: 1.0
*/
@Data
<#if tablePrefix == "*">
@TableName(value = "${classInfo.tableName}")
<#else>
@TableName(value = "${tablePrefix}${classInfo.tableName}")
</#if>
@ApiModel(value = "${classInfo.className}对象", description = "${classInfo.classComment}")
public class ${classInfo.className} implements Serializable {

    private static final long serialVersionUID = 1L;
<#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
    <#list classInfo.fieldList as fieldItem >

    /**
    * ${fieldItem.fieldComment}
    */
    @ApiModelProperty("${fieldItem.fieldComment}")
    private ${fieldItem.fieldClass} ${fieldItem.fieldName};
    </#list>
</#if>

}
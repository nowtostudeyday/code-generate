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
@TableName(value = "${classInfo.tableName}")
@ApiModel(value = "${classInfo.className}对象", description = "${classInfo.classComment}")
public class ${classInfo.className} implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
}
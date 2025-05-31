<#if prefix == "*">
package ${packageName}.base.${classInfo.modelName}.entity;
<#else>
package ${packageName}.base.${prefix}.${classInfo.modelName}.entity;
</#if>

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @Author: ${author}
* @CreateTime: ${.now?string('yyyy/MM/dd HH:mm')}
* @Description: ${classInfo.classComment}
* @Version: 1.0
*/
@Data
@TableName(value = "${classInfo.tableName}")
@ApiModel(value = "${classInfo.className}对象", description = "${classInfo.classComment}")
public class ${classInfo.className} implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    // ----------- 不要可删除 ------------

    @ApiModelProperty("备用字段1")
    @TableField(value = "gwf1")
    private String gwf1;

    @ApiModelProperty("备用字段2")
    @TableField(value = "gwf2")
    private String gwf2;

    @ApiModelProperty("备用字段3")
    @TableField(value = "gwf3")
    private String gwf3;

    @ApiModelProperty("备用字段4")
    @TableField(value = "gwf4")
    private String gwf4;

    @ApiModelProperty("备用字段5")
    @TableField(value = "gwf5")
    private String gwf5;
}

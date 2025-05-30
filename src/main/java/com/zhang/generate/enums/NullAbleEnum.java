package com.zhang.generate.enums;

import com.zhang.generate.exception.BizException;
import lombok.Getter;

/**
 * @Description 数据库字段是否允许为空
 * @Author Mr.Zhang
 * @Date 2025/5/29 下午7:49
 * @Version 1.0
 */
@Getter
public enum NullAbleEnum {

    /**
     * 不允许为空
     */
    NO(0, "NO"),

    /**
     * 默认为空
     */
    YES(1, "YES"),
    ;

    private final Integer type;

    private final String desc;

    NullAbleEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static Integer getType(String desc) {
        for (NullAbleEnum value : values()) {
            if (value.getDesc().equals(desc)) {
                return value.getType();
            }
        }
        throw new BizException(200, "未找到对应的数据库字段是否允许为空枚举");
    }
}

package com.zhang.generate.enums;

import lombok.Getter;

/**
 * @Description 策略类型枚举
 * @Author Mr.Zhang
 * @Date 2025/5/28 22:22
 * @Version 1.0
 */
@Getter
public enum StrategyTypeEnum {

    DDD(0, "DDD 领域驱动架构"),
    MVC(1, "MVC 三层架构"),
    ;

    private final Integer type;

    private final String desc;

    StrategyTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}

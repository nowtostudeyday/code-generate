package com.zhang.generate;

import com.zhang.generate.enums.StrategyTypeEnum;
import com.zhang.generate.factory.GenerateStrategyFactory;
import com.zhang.generate.strategy.GenerateStrategy;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/5/28 21:55
 * @Version 1.0
 */
public class GenerateCodeApplication {
    public static void main(String[] args) {
        // 方式一：启用配置文件
        GenerateStrategy strategy = GenerateStrategyFactory.getStrategy(StrategyTypeEnum.MVC.getType());

        strategy.execute();
    }
}

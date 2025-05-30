package com.zhang.generate.factory;

import com.zhang.generate.exception.BizException;
import com.zhang.generate.strategy.GenerateStrategy;
import com.zhang.generate.strategy.impl.DefaultStrategyImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 生成策略工厂
 * @Author Mr.Zhang
 * @Date 2025/5/28 22:20
 * @Version 1.0
 */
public class GenerateStrategyFactory {

    private static final Map<Integer, GenerateStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        // TODO 后续支持动态扩展
        registerStrategy(new DefaultStrategyImpl());
    }

    private static void registerStrategy(GenerateStrategy strategy) {
        STRATEGY_MAP.put(strategy.getType(), strategy);
    }

    public static GenerateStrategy getStrategy(Integer type) {
        GenerateStrategy strategy = STRATEGY_MAP.get(type);
        if (strategy == null) {
            throw new BizException(200, "未找到对应的生成策略");
        }
        return strategy;
    }
}

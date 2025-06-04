package generateCode;

import com.zhang.generate.bean.ConfigInfo;
import com.zhang.generate.bean.Database;
import com.zhang.generate.config.GlobalConfig;
import com.zhang.generate.enums.StrategyTypeEnum;
import com.zhang.generate.factory.GenerateStrategyFactory;
import com.zhang.generate.strategy.GenerateStrategy;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/6/4 21:27
 * @Version 1.0
 */
public class codeGenerateTest {

    public static void main(String[] args) {
        // 方式二：手动设置
        String projectPath = System.getProperty("user.dir");
        Database database = new Database().setDriver("com.mysql.cj.jdbc.Driver")
                .setUrl("")
                .setUsername("")
                .setPassword("");

        ConfigInfo configInfo = new ConfigInfo()
                .setDatabase(database)
                .setTableNames("execute_log")  // * 代表生成数据库所有表，默认为 *
                .setAuthor("zhanggongming")  // 作者信息
                .setPrefix("*")  // 自定义前缀，eg: 我想生成的文件在 com.zhang.system，此处就填写 system。默认为 *，代表直接生成在 packageName 目录下
                .setPackageName("com.zhang")  //  生成代码 package 包名
                .setOnlyResource(false)  // 是否只生成资源层
                .setProjectPath(projectPath);

        GlobalConfig.setConfigInfo(configInfo);

        GenerateStrategy strategy = GenerateStrategyFactory.getStrategy(StrategyTypeEnum.DDD.getType());
        strategy.execute();
    }
}

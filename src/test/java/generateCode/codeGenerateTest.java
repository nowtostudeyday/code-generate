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
        Database database = new Database();
        database.setDriver("com.mysql.cj.jdbc.Driver");
        database.setUrl("");
        database.setUsername("");
        database.setPassword("");

        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setDatabase(database);
        configInfo.setTableNames("execute_log");  // * 代表生成数据库所有表，默认为 *
        configInfo.setAuthor("zhanggongming");  // 作者信息
        configInfo.setPrefix("*");  // 自定义路径前缀，eg: 我想生成的文件在 com.zhang.system，此处就填写 system。默认为 *，代表直接生成在 packageName 目录下
        configInfo.setTablePrefix("tb_");  // 自定义表名前缀
        configInfo.setPackageName("com.zhang");  //  生成代码 package 包名
        configInfo.setOnlyResource(false);  // 是否只生成资源层
        configInfo.setProjectPath(projectPath);
        configInfo.setMvcMode(false);  // MVC 模式（true：聚合模式 | false：分离模式）

        GlobalConfig.setConfigInfo(configInfo);

        GenerateStrategy strategy = GenerateStrategyFactory.getStrategy(StrategyTypeEnum.MVC.getType());
        strategy.execute();
    }
}

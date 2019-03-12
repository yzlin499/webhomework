package top.yzlin.homework;

import top.yzlin.homework.database.ConnectionManager;
import top.yzlin.homework.database.DBInfo;
import top.yzlin.homework.database.SQLTools;
import top.yzlin.homework.doa.UserDAOImpl;

public class ContextConfig {
    public final static Class[] COMPONENTS = new Class[]{
            //数据库基本信息
            DBInfo.class,
            //数据库连接管理
            ConnectionManager.class,
            //数据库对象封装工具
            SQLTools.class,
            //UserDAO
            UserDAOImpl.class
    };
}

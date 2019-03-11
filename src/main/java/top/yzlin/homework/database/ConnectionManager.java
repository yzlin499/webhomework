package top.yzlin.homework.database;

import top.yzlin.homework.ioc.ComponentInit;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class ConnectionManager implements ComponentInit {
    private DBInfo dbInfo;
    private List<Connection> connections;
    private List<Boolean> connectionsUse;

    @Resource
    public void setDbInfo(DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    @Override
    public void init() {
        try {
            connections =new ArrayList<>(dbInfo.getPools());
            connectionsUse=new ArrayList<>(dbInfo.getPools());
            Class.forName(dbInfo.getDriver());
            for (int i = 0; i < dbInfo.getPools(); i++) {
                connections.add(DriverManager.getConnection(dbInfo.getJdbcUrl(),dbInfo.getUser(),dbInfo.getPassword()));
                connectionsUse.add(true);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("无法获取到数据库连接");
            e.printStackTrace();
        }
    }

    /**
     * 我觉得这么控制会话会比较安全吧
     * @param func
     * @param <T>
     * @return
     */
    public <T> T getStatement(Function<Statement,T> func){
        return getConnection(c->{
            try {
                Statement statement=c.createStatement();
                T t=func.apply(statement);
                statement.close();
                return t;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public void getConnection(Consumer<Connection> func){
        getConnection(c->{
            func.accept(c);
            return null;
        });
    }

    public <T> T getConnection(Function<Connection,T> func){
        int index=-1;
        Out:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < connectionsUse.size(); j++) {
                if(connectionsUse.get(j)){
                    connectionsUse.set(j,false);
                    index=j;
                    break Out;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(index==-1){
            try {
                connections.add(DriverManager.getConnection(dbInfo.getJdbcUrl(),dbInfo.getUser(),dbInfo.getPassword()));
                connectionsUse.add(false);
                index=connectionsUse.size()-1;
            } catch (SQLException e) {
                System.out.println("创建新链接失败");
                e.printStackTrace();
            }
        }
        T t=func.apply(connections.get(index));
        connectionsUse.set(index,true);
        return t;
    }



}

import top.yzlin.homework.Context;
import top.yzlin.homework.database.ConnectionManager;
import top.yzlin.homework.database.DBInfo;
import top.yzlin.homework.database.SQLTools;
import top.yzlin.homework.doa.UserDAO;
import top.yzlin.homework.doa.UserDAOImpl;
import top.yzlin.homework.entity.User;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Pattern;

import static top.yzlin.homework.Context.getResources;


public class Test {
    private User user;

    public User getUser(double a) {
        System.out.println(a);
        return user;
    }

    public Object get(){
        return 123;
    }

    @Resource
    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InvocationTargetException, IllegalAccessException {
        Context context=Context.getInstance();
        context.addComponent(DBInfo.class);
        context.addComponent(ConnectionManager.class);
        context.addComponent(SQLTools.class);
        context.addComponent(UserDAOImpl.class);

        System.out.println(context.getComponent(UserDAO.class)
                .getUserInfo("admin"));


    }
}

import top.yzlin.homework.entity.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.text.ParseException;


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

    public static void main(String[] args) throws URISyntaxException, IOException, InvocationTargetException, IllegalAccessException, ParseException {







    }
}

import top.yzlin.homework.entity.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.CHINESE);
        Date date = simpleDateFormat.parse("2019-03-14T17:15");

        System.out.println(date.getTime());






    }
}

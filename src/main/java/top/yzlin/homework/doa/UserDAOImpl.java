package top.yzlin.homework.doa;

import top.yzlin.homework.database.ConnectionManager;
import top.yzlin.homework.database.SQLTools;
import top.yzlin.homework.entity.User;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private ConnectionManager cm;
    private SQLTools sqlTools;

    @Resource
    public void setCm(ConnectionManager cm) {
        this.cm = cm;
    }

    @Resource
    public void setSqlTools(SQLTools sqlTools) {
        this.sqlTools = sqlTools;
    }

    @Override
    public User getUserInfo(String name) {
        return cm.getPreparedStatement("select * from user_info where user=?", ps -> {
            try {
                ps.setString(1,name);
                ResultSet resultSet = ps.executeQuery();
                resultSet.first();
                return resultSet.next() ? sqlTools.resultSetToObject(User.class, resultSet) : null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}

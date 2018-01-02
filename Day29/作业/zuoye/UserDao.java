package zuoye;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public static int add(User user) throws SQLException {
        int i = new QueryRunner1().update(Jdbc.getConn(),
                "INSERT INTO user values(null,?,?)",
                user.getUsername(), user.getPassword());
        return i;
    }
    public static User select(String username) throws SQLException {
        User user = new QueryRunner1().query(Jdbc.getConn(),
                "select * from user where username = ?",
                new BeanHandler<User>(User.class),
                username);
        return user;
    }
}

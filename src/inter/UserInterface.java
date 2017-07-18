package inter;

import com.Article;
import com.User;

import java.util.List;

/**
 * Created by sprke on 2017/6/29.
 */
public interface UserInterface {

    public User selectUserById(int id);//返回是个对象

    public List<User> selectUsers(String name);//返回是个list集合

    public void addUser (User user);//增加

    public void updateUser(User user);//更新

    public void deleteUser(User user);//删除

    public List<Article> getUserArticles(int id);//级联查询
}

package test;

import com.Article;
import com.User;
import inter.UserInterface;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by sprke on 2017/6/29.
 */
public class Test {

    public static SqlSessionFactory sqlSessionFactory;
    public static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    public static void main(String[] args) {

        SqlSession session = getSqlSession();
        try {
//            使用原始方法
//            User u =(User) session.selectOne("com.UserMapper.selectUserById", 1);

//            使用接口返回一个对象
//            UserInterface mapper = session.getMapper(UserInterface.class);
//            User u = mapper.selectUserById(1);
//            System.out.println(u.getUsername());
//            System.out.println(u.getUserAge());

//            使用接口返回一个list集合
//            UserInterface mapper = session.getMapper(UserInterface.class);
//            List<User> list = mapper.selectUsers("summer");
//            System.out.println(list.size());
//            for(User u : list){
//                System.out.println(u.getUserName());
//                System.out.println(u.getUserAddress());
//            }

//            增加用户
//            User user = new User();
//            user.setUserName("哈哈");
//            user.setUserAge(12);
//            user.setUserAddress("石家庄");
//            UserInterface mapper = session.getMapper(UserInterface.class);
//            mapper.addUser(user);
//            session.commit();
//            System.out.println("当前增加的用户id"+user.getId());

            //跟新用户
//            UserInterface mapper = session.getMapper(UserInterface.class);
//            User user = mapper.selectUserById(4);
//            user.setUserName("哈哈哈哈");
//            mapper.updateUser(user);
//            session.commit();
//            System.out.println(user.getUserName());

            //删除
//            UserInterface mapper = session.getMapper(UserInterface.class);
//            User user = mapper.selectUserById(4);
//            mapper.deleteUser(user);
//            session.commit();

            //级联查询
            UserInterface mapper = session.getMapper(UserInterface.class);
            List<Article> userArticlesList = mapper.getUserArticles(1);
            for (Article article : userArticlesList ) {
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+":地址:"+
                        article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
}

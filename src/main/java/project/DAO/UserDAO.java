package project.DAO;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.Beans.User;

public interface UserDAO {
//    @Select("select * from user where #{name} = name and #{password} = password")
    public User selectUserBynameAndPassword(@Param("name") String name,@Param("password") String password,@Param("type")int type);
    User selectUserByNameAndPhone(@Param("name")String name,@Param("phone")String phone);
    boolean updateUserPassword(@Param("password")String password,@Param("id")int id);
    boolean insertStudent(@Param("user")User user);
}

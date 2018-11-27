/**
 * 
 */
package spring.boot.sample.sample.dao;

import org.apache.ibatis.annotations.Param;
import spring.boot.sample.sample.entity.User;
/**
 * 用户表DAO接口
 * @author majunsheng
 */
public interface UserDao{
	public User get(@Param("uid") Integer uid);

    public int delete(@Param("uid") Integer uid);

}
/**
 * 
 */
package spring.boot.sample.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.sample.sample.dao.UserDao;
import spring.boot.sample.sample.entity.User;

import java.util.List;

/**
 * 用户表Service
 * @author majunsheng
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = false)
    public List<User> findAll() {
      return userDao.findAll();
    }
    @Transactional(readOnly = false)
    public void deleteById(Integer uid) {
        userDao.delete(uid);
    }

}
/**
 * 
 */
package spring.boot.sample.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.sample.sample.dao.EmployeeDao;
import spring.boot.sample.sample.entity.Employee;

import java.util.List;

/**
 * 用户表Service
 * @author majunsheng
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    public List<Employee> findAll(){
       return employeeDao.findAll();
    }

    public Employee findById(Integer id) {
        return employeeDao.get(id);
    }

    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        employeeDao.delete(id);
    }

}
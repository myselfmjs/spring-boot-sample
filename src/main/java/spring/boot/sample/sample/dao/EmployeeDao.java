/**
 * 
 */
package spring.boot.sample.sample.dao;

import org.apache.ibatis.annotations.Param;
import spring.boot.sample.sample.entity.Employee;

import java.util.List;

/**
 * 用户表DAO接口
 * @author majunsheng
 */
public interface EmployeeDao {

    public List<Employee> findAll();

	public Employee get(@Param("id") Integer id);

    public int delete(@Param("id") Integer id);

}
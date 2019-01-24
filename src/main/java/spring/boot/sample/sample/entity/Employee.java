/**
 * 
 */
package spring.boot.sample.sample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;




/**
 * 用户表实体
 * @author majunsheng
 */
public class Employee {
	
	private static final long serialVersionUID = 1L;

	
	private Integer id;	

	@Length(max=255)
	private String name;	

	
	private Integer age;	


	public Employee() {
		super();
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}
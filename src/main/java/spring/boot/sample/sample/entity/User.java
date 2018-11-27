/**
 * 
 */
package spring.boot.sample.sample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户表实体
 * @author majunsheng
 */
public class User{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer uid;	

	@Length(max=255)
	private String username;	

	@Length(max=255)
	private String password;	


	public User() {
		super();
	}

	@JsonProperty("uid")
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
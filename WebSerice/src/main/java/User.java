import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="User")
@NamedQuery(name="FIND_ALL", query = "SELECT b FROM User b")
public class User implements Serializable {

	private static final long serialVersionUID = 2155131245801764001L;

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private int age;
	private String email;
	
	public User(){
		
	}
	
	public User(String name, String surname, int age, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

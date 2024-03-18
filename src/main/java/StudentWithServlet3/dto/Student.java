package StudentWithServlet3.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;
private String name;
private String email;
private String password;
private String address;
private long phone;
private long addhar;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the phone
 */
public long getPhone() {
	return phone;
}
/**
 * @param phone the phone to set
 */
public void setPhone(long phone) {
	this.phone = phone;
}
/**
 * @return the addhar
 */
public long getAddhar() {
	return addhar;
}
/**
 * @param addhar the addhar to set
 */
public void setAddhar(long addhar) {
	this.addhar = addhar;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
			+ address + ", phone=" + phone + ", addhar=" + addhar + "]";
}


}

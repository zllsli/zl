package cn.com.javaweb.demo.entity;

public class User {
    private int id;
    private String userName;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String password;
    private String photo;
    
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User() {
		super();
	}
	public User(int id, String userName, String name, String sex, int age, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
//		this.password = password;
	}
	public User(int id, String userName, String name, String sex, int age, String phone, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + "]";
	}
    
    
}

package vo;

import java.util.Date;

public class Member { //memberfield 소문자...
	private String userid;
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String is_Lunar;
	private String cPhone;
	private String email;
	private String habit;
	private Date   regDate;
	public Member() {}
	public Member(String userid, String pwd, String name, String gender, String birth, String is_Lunar, String cPhone,
			String email, String habit, Date regDate) {
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.is_Lunar = is_Lunar;
		this.cPhone = cPhone;
		this.email = email;
		this.habit = habit;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", is_Lunar=" + is_Lunar + ", cPhone=" + cPhone + ", email=" + email + ", habit=" + habit
				+ ", regDate=" + regDate + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIs_Lunar() {
		return is_Lunar;
	}

	public void setIs_Lunar(String is_Lunar) {
		this.is_Lunar = is_Lunar;
	}

	public String getCPhone() {
		return cPhone;
	}

	public void setCPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}

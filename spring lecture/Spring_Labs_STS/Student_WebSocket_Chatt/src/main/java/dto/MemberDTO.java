package dto;

public class MemberDTO {
	private String userid;
	private String password;
	private String nickname;
	
	public MemberDTO(){}

	public MemberDTO(String userid, String password, String nickname) {
		this.userid = userid;
		this.password = password;
		this.nickname = nickname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", password=" + password + ", nickname=" + nickname + "]";
	}
	

	
}

package dao;

import java.util.List;

import vo.Member;
import vo.Notice;

public interface MemberDao {

	//회원가입
	public int insertMember(Member member);
	
	public int idCheck(String userid);
	
	public int loginCheck(String userid, String pwd);
	
	public Member getMember(String userid);
	
	//회원수정
	public int updateMember(Member member);
	
	//권한부여
	public void insertRoll(String userid);
}

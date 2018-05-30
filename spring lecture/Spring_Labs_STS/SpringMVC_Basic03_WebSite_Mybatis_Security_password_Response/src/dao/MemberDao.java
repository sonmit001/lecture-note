package dao;

import java.sql.SQLException;

import vo.Member;

public interface MemberDao {
	//회원정보 얻기
	public Member getMember(String uid) throws ClassNotFoundException, SQLException;
	
	//회원가입
	public int insert(Member member) throws ClassNotFoundException, SQLException;
	
	public int idCheck(String userid);
	
	//수정
	public int updateMember(Member member) throws ClassNotFoundException, SQLException;
}

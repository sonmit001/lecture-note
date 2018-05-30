package dao;

import dto.MemberDTO;
public interface MemberDAO {

	public MemberDTO getMember(String userid);
	public int insert(MemberDTO memberDTO);
	public int grant(MemberDTO memberDTO);
}

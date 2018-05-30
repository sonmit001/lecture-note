package kr.or.kosta.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.or.kosta.dto.emp;

public interface EmpDAO {
	public ArrayList<emp> getEmpList(int cpage, int pagesize) throws SQLException;
	
	public emp loginEmp(String ename,String empno);
	public int totalboardCount();//totalboardCount
	public int joinEmp(emp e);//회원등록
	public int editEmp(emp e);//회원수정
	public int delEmp(String empno);//회원삭제
	public List<emp> getSearch(HashMap<String, Object> map);//회원검색
	public List<emp> multiEmpSearch(HashMap<String, String> map);//다중검색
}

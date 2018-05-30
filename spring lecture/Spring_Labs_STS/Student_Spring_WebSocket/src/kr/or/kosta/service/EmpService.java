package kr.or.kosta.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.dao.EmpDAO;
import kr.or.kosta.dto.emp;

@Service
public class EmpService {

		@Autowired
		private SqlSession sqlsession;
		
		//로그인
		public emp getLogin(String ename, String empno) {
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			emp e = empdao.loginEmp(ename, empno);
			return e;
		}
		
		
		//회원 리스트
		public List<emp> getEmpList(String cp, String ps) throws SQLException {
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			int totalemplist = empdao.totalboardCount();
			   
			if(cp == null || cp.trim().equals("")){
				cp = "1"; 
			}
			if(ps == null || ps.trim().equals("")){
				ps = "5"; 
			}
			
			int cpage = Integer.parseInt(cp);
			int pagesize = Integer.parseInt(ps);
			int pagecount = 0;
			   
			if(totalemplist % pagesize == 0){
				   pagecount = totalemplist/pagesize;
			}else{
				   pagecount = (totalemplist/pagesize) +1;
			}
			
			List<emp> list = empdao.getEmpList(cpage, pagesize);
			System.out.println(list.toString());
			return list;
		}
		//회원등록
		public int joinEmp(emp e) {
			System.out.println("여기는 EmpService joinEmp 시작");
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			System.out.println("여기는 EmpService joinEmp 중간");
			int row = empdao.joinEmp(e);
			System.out.println("여기는 EmpService joinEmp 끝");
			return row;
		}
		//회원수정
		public int editEmp(emp e) {
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			int row = empdao.editEmp(e);
			System.out.println("service : 수정성공");
			return row;
		}
		//회원삭제  
		public int delEmp(String empno) {
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			int row = empdao.delEmp(empno);
			System.out.println("service : 삭제성공");
			return row;
		}
		public List<emp> getSearch(String searchtype, String search){
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
		
			HashMap<String, Object> map = new HashMap<String, Object>();
			if(searchtype.equals("empno")) {
				map.put("empno", search);
			}else if(searchtype.equals("ename")) {
				map.put("ename", search);
			}else if(searchtype.equals("deptno")) {
				map.put("deptno", search);
			}  
			List<emp> list = empdao.getSearch(map);
			System.out.println(list.toString());
			return list;
		}
		public List<emp> multiEmpSearch(String ename, String deptno, String empno, String keyvalue){
			EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
			HashMap<String, String> map = new HashMap<String,String>();
			map.put("ename",ename);
			map.put("deptno",deptno);
			map.put("empno",empno);
			map.put("keyvalue",keyvalue);
			List<emp> list = empdao.multiEmpSearch(map);
			System.out.println(list.toString());
			return list;
			
		}
}

package kr.or.bit.model;

import java.util.List;

public class EmpDTO {

	int empno;
	String ename;
	String job;
	int mgr;
	String hiredate;
	int sal;
	int comm;
	int deptno;
	String outmsg;
	private List<EmpDTO> empList;
	
	public List<EmpDTO> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpDTO> empList) {
		this.empList = empList;
	}

	public String getOutmsg() {
		return outmsg;
	}

	public void setOutmsg(String outmsg) {
		this.outmsg = outmsg;
	}

	public EmpDTO() {
	}

	public EmpDTO(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

}

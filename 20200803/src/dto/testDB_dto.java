package dto;

public class testDB_dto {
int sal;
String empno, ename, job, dname;
public testDB_dto(int sal, String empno, String ename, String job, String dname) {
	super();
	this.sal = sal;
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.dname = dname;
}
public int getSal() {
	return sal;
}
public String getEmpno() {
	return empno;
}
public String getEname() {
	return ename;
}
public String getJob() {
	return job;
}
public String getDname() {
	return dname;
}




}

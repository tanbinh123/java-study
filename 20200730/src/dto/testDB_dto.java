package dto;

public class testDB_dto {
int empno;
String ename, job;
public testDB_dto(int empno, String ename, String job) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.job = job;
}
public int getEmpno() {
	return empno;
}
public String getEname() {
	return ename;
}
public String getJob() {
	return job;
}


}

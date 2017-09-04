/*
 * ============================================================
 * 2011/11/26 kait init
 * ============================================================
 */
package org.cic.template.web.login;

/**
 * 指導教授vo
 * @author kait
 *
 */
public class ProfessorInfoVo {

	private String memberId;
	private String memberName;
	
	private String deptId;
	private String deptName;
	private String schoolId;
	private String schoolName;
	private String conTel;
	private String email;
	private String mobile;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
    	return memberName;
    }
	public void setMemberName(String memberName) {
    	this.memberName = memberName;
    }
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getConTel() {
		return conTel;
	}
	public void setConTel(String conTel) {
		this.conTel = conTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}

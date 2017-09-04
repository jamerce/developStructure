package org.cic.template.web.login;

import java.io.Serializable;

public class LoginUserVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id; //身份證字號
	private String memberId; //會員代碼
	private String memberName;
	private String email;
	private String address;
	private String conTel;
	private String mobile;
	private String faxNo;
	private String deptId;
	private String deptName;
	private String company;
	private String companyDeptName;
	private String userUnino; //預設為學校統編
	private String checkNo; //
	private String checkTitle; //
	private String userType; //登入身份的種類，例如SM、PM、IN
	private String checkConfirm; //是否已認證
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConTel() {
		return conTel;
	}
	public void setConTel(String conTel) {
		this.conTel = conTel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyDeptName() {
		return companyDeptName;
	}
	public void setCompanyDeptName(String companyDeptName) {
		this.companyDeptName = companyDeptName;
	}
	public String getUserUnino() {
		return userUnino;
	}
	public void setUserUnino(String userUnino) {
		this.userUnino = userUnino;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public String getCheckTitle() {
		return checkTitle;
	}
	public void setCheckTitle(String checkTitle) {
		this.checkTitle = checkTitle;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCheckConfirm() {
		return checkConfirm;
	}
	public void setCheckConfirm(String checkConfirm) {
		this.checkConfirm = checkConfirm;
	}
	
	
	
}

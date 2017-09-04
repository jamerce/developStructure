/*
 * 
 */
package org.cic.template.web.onlineapply;

import java.io.File;
import java.util.List;


/**
 * 
 * @author kait
 *
 */
public class OnlineApplyVo {
	
	private Long id;
	
	private String regId; //報名主鍵
	private String groupId; //梯次ID
	private String groupKind; //梯次種類
	private String isAlert; //是否要秀警語
	private String openClassId; //開課課程主鍵
	private String classId; //課程編號
	private List<String> openClassIdList; //梯次課程代號 
	private List<String> choiceOpenClassIdList; //所選擇的課程代號
	private String contel;
	private String mobile;
	private String invoiceTitle;
	private String unino;
	private String invoiceItem; //發票品名
	private String zip; //區碼
	private String address; //地址
	
	private String billNo; //帳號編號
	
	private File uploadFile;
	private String uploadFileFileName;
	private String isUploadFile; //是否有上傳檔案
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getOpenClassId() {
		return openClassId;
	}
	public void setOpenClassId(String openClassId) {
		this.openClassId = openClassId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public List<String> getOpenClassIdList() {
		return openClassIdList;
	}
	public void setOpenClassIdList(List<String> openClassIdList) {
		this.openClassIdList = openClassIdList;
	}
	public List<String> getChoiceOpenClassIdList() {
		return choiceOpenClassIdList;
	}
	public void setChoiceOpenClassIdList(List<String> choiceOpenClassIdList) {
		this.choiceOpenClassIdList = choiceOpenClassIdList;
	}
	public String getGroupKind() {
		return groupKind;
	}
	public void setGroupKind(String groupKind) {
		this.groupKind = groupKind;
	}
	public String getContel() {
		return contel;
	}
	public void setContel(String contel) {
		this.contel = contel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getUnino() {
		return unino;
	}
	public void setUnino(String unino) {
		this.unino = unino;
	}
	public String getInvoiceItem() {
		return invoiceItem;
	}
	public void setInvoiceItem(String invoiceItem) {
		this.invoiceItem = invoiceItem;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getIsAlert() {
		return isAlert;
	}
	public void setIsAlert(String isAlert) {
		this.isAlert = isAlert;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getIsUploadFile() {
		return isUploadFile;
	}
	public void setIsUploadFile(String isUploadFile) {
		this.isUploadFile = isUploadFile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}

package org.cic.template.intercept;

import org.apache.log4j.Logger;
import org.cic.template.web.login.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorizationService")
public class AuthorizationServiceImpl implements IAuthorizationService{
	
	private static final Logger log = Logger.getLogger(AuthorizationServiceImpl.class);
	

	@Autowired
	//private MemberMapper memberMapper;
	
	/**
	 * @see IAuthorizationService#getLoginUser(String, String)
	 */
	public LoginUserVo getLoginUser(String sessionId, String mId) throws Exception{
		log.debug("start getLoginUser");
		
		LoginUserVo loginVo = null;

		/*MemberEntity memberEntity = sessioninfoMapper.selectBySessionIdAndMid(sessininfoModel);
		
		if(memberEntity != null){

			loginVo = new LoginUserVo();
			
			loginVo.setMemberId(memberEntity.getmId());
			loginVo.setMemberName((String)memberEntity.getmCname());
			loginVo.setEmail((String)memberEntity.getmEmail());
			loginVo.setConTel((String)memberEntity.getmContel());
			loginVo.setConMobile((String)memberEntity.getmMob());
			loginVo.setAddress((String)memberEntity.getmAddr());
			loginVo.setFaxNo((String)memberEntity.getmFax());
			loginVo.setAssignteacher(memberEntity.getmAssignteacher());
			loginVo.setCompany((String)memberEntity.getmCompany()); //公司名稱
			loginVo.setCompanyDeptName((String)memberEntity.getmDepartment()); // 部門
			loginVo.setSchoolId(memberEntity.getmSid());
			String schoolName = memberEntity.getSchool() == null? "": memberEntity.getSchool().getsName();
			loginVo.setSchoolName(schoolName); //學校名稱
			loginVo.setDeptId(memberEntity.getmDid());
			String deptName = memberEntity.getDepartment() == null? "": memberEntity.getDepartment().getdName();
			loginVo.setDeptName(deptName); //系所名稱
			loginVo.setCheckNo((String)memberEntity.getmCheckno());
			loginVo.setCheckTitle((String)memberEntity.getmChecktitle());
			String unino = memberEntity.getSchool() == null? "": (String)memberEntity.getSchool().getsUnino();
			loginVo.setUserUnino(unino);
			loginVo.setUserType(memberEntity.getmId().substring(0, 2));
			loginVo.setCheckConfirm(memberEntity.getmConfirm());
			
			//取得指導教授的明細資料
			if(StringUtils.trimToNull(memberEntity.getmAssignteacher()) != null){
				MemberEntity professorMemberModel = memberMapper.selectDetailByPk(memberEntity.getmAssignteacher());
				
				loginVo.getProfessorInfoVo().setMemberId(professorMemberModel.getmId());
				loginVo.getProfessorInfoVo().setMemberName((String)professorMemberModel.getmCname());				
				loginVo.getProfessorInfoVo().setSchoolId(professorMemberModel.getmSid());
				if(professorMemberModel.getSchool() == null){
					loginVo.getProfessorInfoVo().setSchoolName("");
				}else{
					loginVo.getProfessorInfoVo().setSchoolName(professorMemberModel.getSchool().getsName());
				}
				loginVo.getProfessorInfoVo().setDeptId(professorMemberModel.getmDid());				
				if(professorMemberModel.getDepartment() == null){
					loginVo.getProfessorInfoVo().setDeptName("");
				}else{
					loginVo.getProfessorInfoVo().setDeptName(professorMemberModel.getDepartment().getdName());
				}				
				loginVo.getProfessorInfoVo().setConTel((String)professorMemberModel.getmComTel());
				loginVo.getProfessorInfoVo().setEmail((String)professorMemberModel.getmEmail());
				loginVo.getProfessorInfoVo().setMobile((String)professorMemberModel.getmMob());
			}
		}*/
		log.debug("end getLoginUser");
		return loginVo;
	}

	
}

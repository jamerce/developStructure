/*
 * =========================================================================
 * 報名申請
 * 2016/10/19 kait  init
 * =========================================================================
 */
package org.cic.template.web.onlineapply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.cic.template.exception.ExceptionHandle;
import org.cic.template.persistent.mybatis.tftis.model.Apuser;
import org.cic.template.persistent.mybatis.tftis.model.NoviolationStatusLog;
import org.cic.template.web.util.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author kait
 *
 */
public class OnlineApplyAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(OnlineApplyAction.class);
	
	@Autowired
	private IOnlineApplyService onlineApplyService;
	
	private OnlineApplyVo queryVo;
	private LogDetailVo detailVo;
	private List<NoviolationStatusLog> poList;
	private NoviolationStatusLog logPo;
	private List<Apuser> apuserList;
	

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 程式初始入口
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception {	
		try{
			
			int count = onlineApplyService.queryCount(queryVo);
			if(count > 0){
				List<NoviolationStatusLog> poList = onlineApplyService.query(queryVo, this.getPagingVo());
	
				this.getPagingVo().setTotal(count);
				this.getPagingVo().setDataList(poList);

			} else{
				this.getPagingVo().setDataList(new ArrayList<NoviolationStatusLog>());
			}
			
		} catch(Exception e){
			log.error(e);
			this.addActionError(ExceptionHandle.msgForPageView(e));
			
		} finally{

		}
		
		return SUCCESS;
	}
	
	/**
	 * 查詢
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {	
		try{
			
			int count = onlineApplyService.queryCount(queryVo);
			if(count > 0){
				List<NoviolationStatusLog> poList = onlineApplyService.query(queryVo, this.getPagingVo());
	
				this.getPagingVo().setTotal(count);
				this.getPagingVo().setDataList(poList);

			} else{
				this.getPagingVo().setDataList(new ArrayList<NoviolationStatusLog>());
			}
			
		} catch(Exception e){
			log.error(e);
			
		} finally{

		}
		
		return SUCCESS;
	}
	
	/**
	 * 修改頁面
	 * @return
	 * @throws Exception
	 */
	public String initModifyPage() throws Exception {	
		try{
			
			this.logPo = onlineApplyService.queryLog(queryVo);
			
		} catch(Exception e){
			log.error(e);
			
		} finally{

		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 申請案件確認送出
	 * @return
	 * @throws Exception
	 */
	public String doModify() throws Exception {

		try{	
			onlineApplyService.save(detailVo);
			
			this.addActionMessage("儲存成功");
			this.jsonResultMap = new HashMap<String, String>();
			this.jsonResultMap.put("isSuccess", "Y");
			
		} catch(Exception e){
			log.error(e);
			
			log.error(e);
			this.addActionError(e.toString());
			this.jsonResultMap = new HashMap<String, String>();
			this.jsonResultMap.put("isSuccess", "N");
			this.jsonResultMap.put("msg", ExceptionHandle.msgForPageView(e.toString()));
		}
		
		return SUCCESS;
	}

	public LogDetailVo getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(LogDetailVo detailVo) {
		this.detailVo = detailVo;
	}

	public List<NoviolationStatusLog> getPoList() {
		return poList;
	}

	public void setPoList(List<NoviolationStatusLog> poList) {
		this.poList = poList;
	}

	public IOnlineApplyService getOnlineApplyService() {
		return onlineApplyService;
	}

	public void setOnlineApplyService(IOnlineApplyService onlineApplyService) {
		this.onlineApplyService = onlineApplyService;
	}

	public OnlineApplyVo getQueryVo() {
		return queryVo;
	}

	public void setQueryVo(OnlineApplyVo queryVo) {
		this.queryVo = queryVo;
	}

	public List<Apuser> getApuserList() {
		return apuserList;
	}

	public void setApuserList(List<Apuser> apuserList) {
		this.apuserList = apuserList;
	}

	public NoviolationStatusLog getLogPo() {
		return logPo;
	}

	public void setLogPo(NoviolationStatusLog logPo) {
		this.logPo = logPo;
	}
	
	
	
}

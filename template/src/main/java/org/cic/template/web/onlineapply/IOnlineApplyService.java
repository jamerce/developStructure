/*
 * 2016-11-07 kait init
 */
package org.cic.template.web.onlineapply;

import java.util.List;

import org.cic.template.exception.TrsException;
import org.cic.template.persistent.mybatis.tftis.model.Apuser;
import org.cic.template.persistent.mybatis.tftis.model.NoviolationStatusLog;
import org.cic.template.web.util.PagingVo;

/**
 * 
 * @author kait
 *
 */
public interface IOnlineApplyService {

	int queryCount(OnlineApplyVo mainVo) throws TrsException;
	
	/**
	 * 新增報名
	 * @param mainVo
	 * @param userVo
	 * @return
	 * @throws TrsException
	 */
	List<NoviolationStatusLog> query(OnlineApplyVo queryVo, PagingVo pagingVo) throws TrsException;
	
	List<Apuser> queryApuser() throws TrsException;
	
	NoviolationStatusLog queryLog(OnlineApplyVo queryVo) throws TrsException;
	
	void save(LogDetailVo detailVo) throws TrsException;
}

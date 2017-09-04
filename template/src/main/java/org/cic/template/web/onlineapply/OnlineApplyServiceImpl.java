/*
 *
 */
package org.cic.template.web.onlineapply;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.cic.template.exception.TrsException;
import org.cic.template.persistent.mybatis.tftis.mapper.ApuserMapper;
import org.cic.template.persistent.mybatis.tftis.mapper.NoviolationStatusLogMapper;
import org.cic.template.persistent.mybatis.tftis.model.Apuser;
import org.cic.template.persistent.mybatis.tftis.model.ApuserCriteria;
import org.cic.template.persistent.mybatis.tftis.model.NoviolationStatusLog;
import org.cic.template.persistent.mybatis.tftis.model.NoviolationStatusLogCriteria;
import org.cic.template.persistent.mybatis.tftis.model.NoviolationStatusLogEntity;
import org.cic.template.web.util.PagingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author kait
 *
 */
@Service("onlineApplyService")
public class OnlineApplyServiceImpl implements IOnlineApplyService {
	
	private static final Logger log = Logger.getLogger(OnlineApplyServiceImpl.class);

	@Autowired
	private NoviolationStatusLogMapper noviolationStatusLogMapper;
	
	@Autowired
	private ApuserMapper apuserMapper;
	
	@Override
	public int queryCount(OnlineApplyVo mainVo) throws TrsException {
		
		NoviolationStatusLogEntity record = this.checkQueryCond();
		return noviolationStatusLogMapper.countByCond(record);
	}

	@Override
	public List<NoviolationStatusLog> query(OnlineApplyVo mainVo, PagingVo pagingVo) throws TrsException {

		List<NoviolationStatusLog> poList = null;
	    try{
	    	NoviolationStatusLogEntity record = this.checkQueryCond();
	    	record.setPagingVo(pagingVo);
	    	
	    	poList = noviolationStatusLogMapper.selectByCond(record);
	    	
	    } catch(Exception e){
	    	log.error(e);
	    	throw new TrsException(e);
	    }
		return poList;
    }

	@Override
	public NoviolationStatusLog queryLog(OnlineApplyVo queryVo) throws TrsException {
		NoviolationStatusLogCriteria example = new NoviolationStatusLogCriteria();
		example.createCriteria().andIdEqualTo(queryVo.getId());
		
		List<NoviolationStatusLog> poList = noviolationStatusLogMapper.selectByExample(example);
		 
		return poList.get(0);
	}

	@Override
    public List<Apuser> queryApuser() throws TrsException {
		
		List<Apuser> poList = null;
	    try{
	    	ApuserCriteria example = new ApuserCriteria();
	    	example.createCriteria().andUpowerEqualTo("1");
	    	
	    	poList = apuserMapper.selectByExample(example);
	    	
	    } catch(Exception e){
	    	log.error(e);
	    	throw new TrsException(e);
	    }
		return poList;
    }
	
	@Override
    public void save(LogDetailVo detailVo) throws TrsException {
				
	    try{
	    	NoviolationStatusLogCriteria example = new NoviolationStatusLogCriteria();
	    	example.createCriteria()
	    		.andIdEqualTo(detailVo.getId())
	    		.andNvnoEqualTo(detailVo.getNvno());
	    	
	    	NoviolationStatusLog record = new NoviolationStatusLog();
	    	record.setMsg(detailVo.getMsg());

	    	int updCnt = noviolationStatusLogMapper.updateByExampleSelective(record, example);
	    	System.out.println("updCnt:" + updCnt);
	    	
	    } catch(Exception e){
	    	log.error(e);
	    	throw new TrsException(e);
	    }

    }
	
	private NoviolationStatusLogEntity checkQueryCond(){
		
		NoviolationStatusLogEntity record = new NoviolationStatusLogEntity();
		return record;
	}
	
	
	private void update(){
		try{
	    	Apuser record = new Apuser();
	    	record.setRemarks("333");
	    	
	    	ApuserCriteria example = new ApuserCriteria();
	    	example.createCriteria().andUserIdEqualTo("f27109");
	    	
	    	//int updCnt = apuserMapper.updateByExampleSelective(record, example);
	    	//this.update();
	    	
	    	NoviolationStatusLog po = new NoviolationStatusLog();
	    	po.setNvno("1111111");
	    	po.setUserGroupNo("B2");
	    	po.setMsg("test");
	    	po.setCreateDate(new Date());
	    	po.setCreateId("11");
	    	po.setFlowType("CCCC");
	    	int seqno = noviolationStatusLogMapper.insertSelective(po);
	    	System.out.println("seqno:" + seqno + "    po.id=" + po.getId());

	    	if(1==1){
	    		//throw new Exception("測試錯誤");
	    	}
	    	
	    } catch(Exception e){
	    	log.error(e);

	    }
	}
}

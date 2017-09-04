package org.cic.template.persistent.mybatis.tftis.model;

import org.cic.template.web.util.PagingVo;

public class NoviolationStatusLogEntity extends NoviolationStatusLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PagingVo pagingVo;

	public PagingVo getPagingVo() {
		return pagingVo;
	}

	public void setPagingVo(PagingVo pagingVo) {
		this.pagingVo = pagingVo;
	}

}

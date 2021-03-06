package org.cic.template.persistent.mybatis.tftis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoviolationStatusLogCriteria {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */public NoviolationStatusLogCriteria(){oredCriteria=new ArrayList<Criteria>();}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */public List<Criteria> getOredCriteria(){return oredCriteria;}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIdIsNull(){addCriterion("ID is null");return (Criteria)this;}public Criteria andIdIsNotNull(){addCriterion("ID is not null");return (Criteria)this;}public Criteria andIdEqualTo(Long value){addCriterion("ID =",value,"id");return (Criteria)this;}public Criteria andIdNotEqualTo(Long value){addCriterion("ID <>",value,"id");return (Criteria)this;}public Criteria andIdGreaterThan(Long value){addCriterion("ID >",value,"id");return (Criteria)this;}public Criteria andIdGreaterThanOrEqualTo(Long value){addCriterion("ID >=",value,"id");return (Criteria)this;}public Criteria andIdLessThan(Long value){addCriterion("ID <",value,"id");return (Criteria)this;}public Criteria andIdLessThanOrEqualTo(Long value){addCriterion("ID <=",value,"id");return (Criteria)this;}public Criteria andIdIn(List<Long> values){addCriterion("ID in",values,"id");return (Criteria)this;}public Criteria andIdNotIn(List<Long> values){addCriterion("ID not in",values,"id");return (Criteria)this;}public Criteria andIdBetween(Long value1,Long value2){addCriterion("ID between",value1,value2,"id");return (Criteria)this;}public Criteria andIdNotBetween(Long value1,Long value2){addCriterion("ID not between",value1,value2,"id");return (Criteria)this;}public Criteria andNvnoIsNull(){addCriterion("NVNO is null");return (Criteria)this;}public Criteria andNvnoIsNotNull(){addCriterion("NVNO is not null");return (Criteria)this;}public Criteria andNvnoEqualTo(String value){addCriterion("NVNO =",value,"nvno");return (Criteria)this;}public Criteria andNvnoNotEqualTo(String value){addCriterion("NVNO <>",value,"nvno");return (Criteria)this;}public Criteria andNvnoGreaterThan(String value){addCriterion("NVNO >",value,"nvno");return (Criteria)this;}public Criteria andNvnoGreaterThanOrEqualTo(String value){addCriterion("NVNO >=",value,"nvno");return (Criteria)this;}public Criteria andNvnoLessThan(String value){addCriterion("NVNO <",value,"nvno");return (Criteria)this;}public Criteria andNvnoLessThanOrEqualTo(String value){addCriterion("NVNO <=",value,"nvno");return (Criteria)this;}public Criteria andNvnoLike(String value){addCriterion("NVNO like",value,"nvno");return (Criteria)this;}public Criteria andNvnoNotLike(String value){addCriterion("NVNO not like",value,"nvno");return (Criteria)this;}public Criteria andNvnoIn(List<String> values){addCriterion("NVNO in",values,"nvno");return (Criteria)this;}public Criteria andNvnoNotIn(List<String> values){addCriterion("NVNO not in",values,"nvno");return (Criteria)this;}public Criteria andNvnoBetween(String value1,String value2){addCriterion("NVNO between",value1,value2,"nvno");return (Criteria)this;}public Criteria andNvnoNotBetween(String value1,String value2){addCriterion("NVNO not between",value1,value2,"nvno");return (Criteria)this;}public Criteria andUserGroupNoIsNull(){addCriterion("USER_GROUP_NO is null");return (Criteria)this;}public Criteria andUserGroupNoIsNotNull(){addCriterion("USER_GROUP_NO is not null");return (Criteria)this;}public Criteria andUserGroupNoEqualTo(String value){addCriterion("USER_GROUP_NO =",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoNotEqualTo(String value){addCriterion("USER_GROUP_NO <>",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoGreaterThan(String value){addCriterion("USER_GROUP_NO >",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoGreaterThanOrEqualTo(String value){addCriterion("USER_GROUP_NO >=",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoLessThan(String value){addCriterion("USER_GROUP_NO <",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoLessThanOrEqualTo(String value){addCriterion("USER_GROUP_NO <=",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoLike(String value){addCriterion("USER_GROUP_NO like",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoNotLike(String value){addCriterion("USER_GROUP_NO not like",value,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoIn(List<String> values){addCriterion("USER_GROUP_NO in",values,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoNotIn(List<String> values){addCriterion("USER_GROUP_NO not in",values,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoBetween(String value1,String value2){addCriterion("USER_GROUP_NO between",value1,value2,"userGroupNo");return (Criteria)this;}public Criteria andUserGroupNoNotBetween(String value1,String value2){addCriterion("USER_GROUP_NO not between",value1,value2,"userGroupNo");return (Criteria)this;}public Criteria andMsgIsNull(){addCriterion("MSG is null");return (Criteria)this;}public Criteria andMsgIsNotNull(){addCriterion("MSG is not null");return (Criteria)this;}public Criteria andMsgEqualTo(String value){addCriterion("MSG =",value,"msg");return (Criteria)this;}public Criteria andMsgNotEqualTo(String value){addCriterion("MSG <>",value,"msg");return (Criteria)this;}public Criteria andMsgGreaterThan(String value){addCriterion("MSG >",value,"msg");return (Criteria)this;}public Criteria andMsgGreaterThanOrEqualTo(String value){addCriterion("MSG >=",value,"msg");return (Criteria)this;}public Criteria andMsgLessThan(String value){addCriterion("MSG <",value,"msg");return (Criteria)this;}public Criteria andMsgLessThanOrEqualTo(String value){addCriterion("MSG <=",value,"msg");return (Criteria)this;}public Criteria andMsgLike(String value){addCriterion("MSG like",value,"msg");return (Criteria)this;}public Criteria andMsgNotLike(String value){addCriterion("MSG not like",value,"msg");return (Criteria)this;}public Criteria andMsgIn(List<String> values){addCriterion("MSG in",values,"msg");return (Criteria)this;}public Criteria andMsgNotIn(List<String> values){addCriterion("MSG not in",values,"msg");return (Criteria)this;}public Criteria andMsgBetween(String value1,String value2){addCriterion("MSG between",value1,value2,"msg");return (Criteria)this;}public Criteria andMsgNotBetween(String value1,String value2){addCriterion("MSG not between",value1,value2,"msg");return (Criteria)this;}public Criteria andRemarksIsNull(){addCriterion("REMARKS is null");return (Criteria)this;}public Criteria andRemarksIsNotNull(){addCriterion("REMARKS is not null");return (Criteria)this;}public Criteria andRemarksEqualTo(String value){addCriterion("REMARKS =",value,"remarks");return (Criteria)this;}public Criteria andRemarksNotEqualTo(String value){addCriterion("REMARKS <>",value,"remarks");return (Criteria)this;}public Criteria andRemarksGreaterThan(String value){addCriterion("REMARKS >",value,"remarks");return (Criteria)this;}public Criteria andRemarksGreaterThanOrEqualTo(String value){addCriterion("REMARKS >=",value,"remarks");return (Criteria)this;}public Criteria andRemarksLessThan(String value){addCriterion("REMARKS <",value,"remarks");return (Criteria)this;}public Criteria andRemarksLessThanOrEqualTo(String value){addCriterion("REMARKS <=",value,"remarks");return (Criteria)this;}public Criteria andRemarksLike(String value){addCriterion("REMARKS like",value,"remarks");return (Criteria)this;}public Criteria andRemarksNotLike(String value){addCriterion("REMARKS not like",value,"remarks");return (Criteria)this;}public Criteria andRemarksIn(List<String> values){addCriterion("REMARKS in",values,"remarks");return (Criteria)this;}public Criteria andRemarksNotIn(List<String> values){addCriterion("REMARKS not in",values,"remarks");return (Criteria)this;}public Criteria andRemarksBetween(String value1,String value2){addCriterion("REMARKS between",value1,value2,"remarks");return (Criteria)this;}public Criteria andRemarksNotBetween(String value1,String value2){addCriterion("REMARKS not between",value1,value2,"remarks");return (Criteria)this;}public Criteria andCreateIdIsNull(){addCriterion("CREATE_ID is null");return (Criteria)this;}public Criteria andCreateIdIsNotNull(){addCriterion("CREATE_ID is not null");return (Criteria)this;}public Criteria andCreateIdEqualTo(String value){addCriterion("CREATE_ID =",value,"createId");return (Criteria)this;}public Criteria andCreateIdNotEqualTo(String value){addCriterion("CREATE_ID <>",value,"createId");return (Criteria)this;}public Criteria andCreateIdGreaterThan(String value){addCriterion("CREATE_ID >",value,"createId");return (Criteria)this;}public Criteria andCreateIdGreaterThanOrEqualTo(String value){addCriterion("CREATE_ID >=",value,"createId");return (Criteria)this;}public Criteria andCreateIdLessThan(String value){addCriterion("CREATE_ID <",value,"createId");return (Criteria)this;}public Criteria andCreateIdLessThanOrEqualTo(String value){addCriterion("CREATE_ID <=",value,"createId");return (Criteria)this;}public Criteria andCreateIdLike(String value){addCriterion("CREATE_ID like",value,"createId");return (Criteria)this;}public Criteria andCreateIdNotLike(String value){addCriterion("CREATE_ID not like",value,"createId");return (Criteria)this;}public Criteria andCreateIdIn(List<String> values){addCriterion("CREATE_ID in",values,"createId");return (Criteria)this;}public Criteria andCreateIdNotIn(List<String> values){addCriterion("CREATE_ID not in",values,"createId");return (Criteria)this;}public Criteria andCreateIdBetween(String value1,String value2){addCriterion("CREATE_ID between",value1,value2,"createId");return (Criteria)this;}public Criteria andCreateIdNotBetween(String value1,String value2){addCriterion("CREATE_ID not between",value1,value2,"createId");return (Criteria)this;}public Criteria andCreateNameIsNull(){addCriterion("CREATE_NAME is null");return (Criteria)this;}public Criteria andCreateNameIsNotNull(){addCriterion("CREATE_NAME is not null");return (Criteria)this;}public Criteria andCreateNameEqualTo(String value){addCriterion("CREATE_NAME =",value,"createName");return (Criteria)this;}public Criteria andCreateNameNotEqualTo(String value){addCriterion("CREATE_NAME <>",value,"createName");return (Criteria)this;}public Criteria andCreateNameGreaterThan(String value){addCriterion("CREATE_NAME >",value,"createName");return (Criteria)this;}public Criteria andCreateNameGreaterThanOrEqualTo(String value){addCriterion("CREATE_NAME >=",value,"createName");return (Criteria)this;}public Criteria andCreateNameLessThan(String value){addCriterion("CREATE_NAME <",value,"createName");return (Criteria)this;}public Criteria andCreateNameLessThanOrEqualTo(String value){addCriterion("CREATE_NAME <=",value,"createName");return (Criteria)this;}public Criteria andCreateNameLike(String value){addCriterion("CREATE_NAME like",value,"createName");return (Criteria)this;}public Criteria andCreateNameNotLike(String value){addCriterion("CREATE_NAME not like",value,"createName");return (Criteria)this;}public Criteria andCreateNameIn(List<String> values){addCriterion("CREATE_NAME in",values,"createName");return (Criteria)this;}public Criteria andCreateNameNotIn(List<String> values){addCriterion("CREATE_NAME not in",values,"createName");return (Criteria)this;}public Criteria andCreateNameBetween(String value1,String value2){addCriterion("CREATE_NAME between",value1,value2,"createName");return (Criteria)this;}public Criteria andCreateNameNotBetween(String value1,String value2){addCriterion("CREATE_NAME not between",value1,value2,"createName");return (Criteria)this;}public Criteria andCreateDateIsNull(){addCriterion("CREATE_DATE is null");return (Criteria)this;}public Criteria andCreateDateIsNotNull(){addCriterion("CREATE_DATE is not null");return (Criteria)this;}public Criteria andCreateDateEqualTo(Date value){addCriterion("CREATE_DATE =",value,"createDate");return (Criteria)this;}public Criteria andCreateDateNotEqualTo(Date value){addCriterion("CREATE_DATE <>",value,"createDate");return (Criteria)this;}public Criteria andCreateDateGreaterThan(Date value){addCriterion("CREATE_DATE >",value,"createDate");return (Criteria)this;}public Criteria andCreateDateGreaterThanOrEqualTo(Date value){addCriterion("CREATE_DATE >=",value,"createDate");return (Criteria)this;}public Criteria andCreateDateLessThan(Date value){addCriterion("CREATE_DATE <",value,"createDate");return (Criteria)this;}public Criteria andCreateDateLessThanOrEqualTo(Date value){addCriterion("CREATE_DATE <=",value,"createDate");return (Criteria)this;}public Criteria andCreateDateIn(List<Date> values){addCriterion("CREATE_DATE in",values,"createDate");return (Criteria)this;}public Criteria andCreateDateNotIn(List<Date> values){addCriterion("CREATE_DATE not in",values,"createDate");return (Criteria)this;}public Criteria andCreateDateBetween(Date value1,Date value2){addCriterion("CREATE_DATE between",value1,value2,"createDate");return (Criteria)this;}public Criteria andCreateDateNotBetween(Date value1,Date value2){addCriterion("CREATE_DATE not between",value1,value2,"createDate");return (Criteria)this;}public Criteria andFlowTypeIsNull(){addCriterion("FLOW_TYPE is null");return (Criteria)this;}public Criteria andFlowTypeIsNotNull(){addCriterion("FLOW_TYPE is not null");return (Criteria)this;}public Criteria andFlowTypeEqualTo(String value){addCriterion("FLOW_TYPE =",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeNotEqualTo(String value){addCriterion("FLOW_TYPE <>",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeGreaterThan(String value){addCriterion("FLOW_TYPE >",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeGreaterThanOrEqualTo(String value){addCriterion("FLOW_TYPE >=",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeLessThan(String value){addCriterion("FLOW_TYPE <",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeLessThanOrEqualTo(String value){addCriterion("FLOW_TYPE <=",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeLike(String value){addCriterion("FLOW_TYPE like",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeNotLike(String value){addCriterion("FLOW_TYPE not like",value,"flowType");return (Criteria)this;}public Criteria andFlowTypeIn(List<String> values){addCriterion("FLOW_TYPE in",values,"flowType");return (Criteria)this;}public Criteria andFlowTypeNotIn(List<String> values){addCriterion("FLOW_TYPE not in",values,"flowType");return (Criteria)this;}public Criteria andFlowTypeBetween(String value1,String value2){addCriterion("FLOW_TYPE between",value1,value2,"flowType");return (Criteria)this;}public Criteria andFlowTypeNotBetween(String value1,String value2){addCriterion("FLOW_TYPE not between",value1,value2,"flowType");return (Criteria)this;}}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table NOVIOLATION_STATUS_LOG
	 * @mbg.generated  Thu Aug 17 15:14:27 CST 2017
	 */public static class Criterion {private String condition;private Object value;private Object secondValue;private boolean noValue;private boolean singleValue;private boolean betweenValue;private boolean listValue;private String typeHandler;public String getCondition(){return condition;}public Object getValue(){return value;}public Object getSecondValue(){return secondValue;}public boolean isNoValue(){return noValue;}public boolean isSingleValue(){return singleValue;}public boolean isBetweenValue(){return betweenValue;}public boolean isListValue(){return listValue;}public String getTypeHandler(){return typeHandler;}protected Criterion(String condition){super();this.condition=condition;this.typeHandler=null;this.noValue=true;}protected Criterion(String condition,Object value,String typeHandler){super();this.condition=condition;this.value=value;this.typeHandler=typeHandler;if (value instanceof List<?>){this.listValue=true;} else {this.singleValue=true;}}protected Criterion(String condition,Object value){this(condition,value,null);}protected Criterion(String condition,Object value,Object secondValue,String typeHandler){super();this.condition=condition;this.value=value;this.secondValue=secondValue;this.typeHandler=typeHandler;this.betweenValue=true;}protected Criterion(String condition,Object value,Object secondValue){this(condition,value,secondValue,null);}}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NOVIOLATION_STATUS_LOG
     *
     * @mbg.generated do_not_delete_during_merge Fri Jul 28 19:47:19 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
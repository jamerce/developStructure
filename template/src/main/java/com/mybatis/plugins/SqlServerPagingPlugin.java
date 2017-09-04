package com.mybatis.plugins;

import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SqlServerPagingPlugin extends PluginAdapter {

	private String pageQualifiedName; // 分頁類的全名
	private String fromIndex; // Page對象中，查詢起始位置的屬性名稱
	private String toIndex; // Page對象中，查詢結束位置的屬性名稱
	private String myBatisRepository; // 接口註解全名

	/**
	 * 驗證插件的配置是否正確
	 */
	public boolean validate(List<String> warnings) {

		pageQualifiedName = properties.getProperty("pageQualifiedName");
		fromIndex = properties.getProperty("fromIndex");
		toIndex = properties.getProperty("toIndex");
		myBatisRepository = properties.getProperty("myBatisRepository");

		if (!stringHasValue(pageQualifiedName)) {
			warnings.add(getString("ValidationError.18", "PaginationPlugin", "pageQualifiedName"));
			return false;
		}
		if (!stringHasValue(fromIndex)) {
			warnings.add(getString("ValidationError.18", "PaginationPlugin", "fromIndex"));
			return false;
		}
		if (!stringHasValue(toIndex)) {
			warnings.add(getString("ValidationError.18", "PaginationPlugin", "toIndex"));
			return false;
		}
		return true;
	}

	/**
	 * 在接口中添加方法
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		String objectName = introspectedTable.getTableConfiguration().getDomainObjectName();// 對象名稱

		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
		interfaze.addImportedType(new FullyQualifiedJavaType(pageQualifiedName));

		if (stringHasValue(myBatisRepository) && myBatisRepository.contains(".")) {
			int index = myBatisRepository.lastIndexOf('.');
			interfaze.addImportedType(new FullyQualifiedJavaType(myBatisRepository));
			interfaze.addAnnotation("@" + myBatisRepository.substring(index + 1));// 接口添加註解
		}

		Method method = new Method();// 統計記錄總條數方法
		method.setName("countTotalData");
		method.setReturnType(new FullyQualifiedJavaType("int"));
		interfaze.addMethod(method);
		method = new Method();// 分頁查詢方法
		method.setName("pageQuery");
		method.addParameter(new Parameter(new FullyQualifiedJavaType(pageQualifiedName), "page"));
		method.setReturnType(new FullyQualifiedJavaType("java.util.List<" + objectName + ">"));
		interfaze.addMethod(method);

		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	/**
	 * 在xml文件中添加需要的元素
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 數據庫表名

		// 產生統計記錄數查詢
		XmlElement countTotalDataElement = new XmlElement("select");
		countTotalDataElement.addAttribute(new Attribute("id", "countTotalData"));
		countTotalDataElement.addAttribute(new Attribute("resultType", "java.lang.Integer"));
		countTotalDataElement.addElement(new TextElement("select count(1) from " + tableName));
		parentElement.addElement(countTotalDataElement);

		// 產生分頁查詢語句
		XmlElement pageQueryElement = new XmlElement("select");
		pageQueryElement.addAttribute(new Attribute("id", "pageQuery"));
		pageQueryElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		pageQueryElement.addAttribute(new Attribute("parameterType", pageQualifiedName));
		XmlElement queryStart = new XmlElement("include");
		queryStart.addAttribute(new Attribute("refid", "PageQueryPrefix"));
		pageQueryElement.addElement(queryStart);
		pageQueryElement.addElement(new TextElement("select "));
		XmlElement query = new XmlElement("include");
		query.addAttribute(new Attribute("refid", "Base_Column_List"));
		pageQueryElement.addElement(query);
		pageQueryElement.addElement(new TextElement("from " + tableName));
		XmlElement queryEnd = new XmlElement("include");
		queryEnd.addAttribute(new Attribute("refid", "PageQuerySuffix"));
		pageQueryElement.addElement(queryEnd);
		parentElement.addElement(pageQueryElement);

		// 產生分頁語句前半部分
		XmlElement paginationPrefixElement = new XmlElement("sql");
		paginationPrefixElement.addAttribute(new Attribute("id", "PageQueryPrefix"));
		XmlElement pageStart = new XmlElement("if");
		pageStart.addAttribute(new Attribute("test", "fromIndex != null and toIndex != null"));
		pageStart.addElement(
				new TextElement("select * from (select row_number() over (order by id desc) as rownum,* from( "));
		paginationPrefixElement.addElement(pageStart);
		parentElement.addElement(paginationPrefixElement);

		// 產生分頁語句後半部分
		XmlElement paginationSuffixElement = new XmlElement("sql");
		paginationSuffixElement.addAttribute(new Attribute("id", "PageQuerySuffix"));
		XmlElement pageEnd = new XmlElement("if");
		pageEnd.addAttribute(new Attribute("test", "fromIndex != null and toIndex != null"));
		pageEnd.addElement(new TextElement(
				"<![CDATA[ ) as t1 ) as t2 where rownum <= #{" + toIndex + "} and rownum >= #{" + fromIndex + "} ]]>"));
		paginationSuffixElement.addElement(pageEnd);
		parentElement.addElement(paginationSuffixElement);

		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	/**
	 * 在Example配置為true時，在Example對象中添加get/set方法
	 */
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String name = "page";
		topLevelClass.addImportedType(new FullyQualifiedJavaType(pageQualifiedName));
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(new FullyQualifiedJavaType(pageQualifiedName));
		field.setName(name);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(new FullyQualifiedJavaType(pageQualifiedName), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType(pageQualifiedName));
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		topLevelClass.addMethod(method);

		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	/**
	 * 在Example配置為true時，對生成的排除了大字段Example查詢語句添加分頁語句
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		XmlElement pageStart = new XmlElement("include"); 
		pageStart.addAttribute(new Attribute("refid", "PageQueryPrefix"));
		element.getElements().add(0, pageStart);

		XmlElement isNotNullElement = new XmlElement("include"); 
		isNotNullElement.addAttribute(new Attribute("refid", "PageQuerySuffix"));
		element.getElements().add(isNotNullElement);

		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}
}

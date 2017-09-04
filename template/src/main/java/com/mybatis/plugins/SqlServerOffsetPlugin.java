package com.mybatis.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SqlServerOffsetPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	/*public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		PrimitiveTypeWrapper integerWrapper = FullyQualifiedJavaType.getIntInstance().getPrimitiveTypeWrapper();
		
		if(introspectedTable.getColumn("fetch") == null){
			Field fetch = new Field();
			fetch.setName("fetch");
			fetch.setVisibility(JavaVisibility.PRIVATE);
			fetch.setType(integerWrapper);
			topLevelClass.addField(fetch);

			Method setFetch = new Method();
			setFetch.setVisibility(JavaVisibility.PUBLIC);
			setFetch.setName("setFetch");
			setFetch.addParameter(new Parameter(integerWrapper, "fetch"));
			setFetch.addBodyLine("this.fetch = fetch;");
			topLevelClass.addMethod(setFetch);

			Method getFetch = new Method();
			getFetch.setVisibility(JavaVisibility.PUBLIC);
			getFetch.setReturnType(integerWrapper);
			getFetch.setName("getFetch");
			getFetch.addBodyLine("return fetch;");
			topLevelClass.addMethod(getFetch);
		}
		
		if(introspectedTable.getColumn("offset") == null){
			Field offset = new Field();
			offset.setName("offset");
			offset.setVisibility(JavaVisibility.PRIVATE);
			offset.setType(integerWrapper);
			topLevelClass.addField(offset);

			Method setOffset = new Method();
			setOffset.setVisibility(JavaVisibility.PUBLIC);
			setOffset.setName("setOffset");
			setOffset.addParameter(new Parameter(integerWrapper, "offset"));
			setOffset.addBodyLine("this.offset = offset;");
			topLevelClass.addMethod(setOffset);

			Method getOffset = new Method();
			getOffset.setVisibility(JavaVisibility.PUBLIC);
			getOffset.setReturnType(integerWrapper);
			getOffset.setName("getOffset");
			getOffset.addBodyLine("return offset;");
			topLevelClass.addMethod(getOffset);

		}
		
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}*/


	/**
	 * 為每個Example類添加fetch和offset屬性已經set、get方法
	 */
	/*@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		PrimitiveTypeWrapper integerWrapper = FullyQualifiedJavaType.getIntInstance().getPrimitiveTypeWrapper();

		Field fetch = new Field();
		fetch.setName("fetch");
		fetch.setVisibility(JavaVisibility.PRIVATE);
		fetch.setType(integerWrapper);
		topLevelClass.addField(fetch);

		Method setFetch = new Method();
		setFetch.setVisibility(JavaVisibility.PUBLIC);
		setFetch.setName("setFetch");
		setFetch.addParameter(new Parameter(integerWrapper, "fetch"));
		setFetch.addBodyLine("this.fetch = fetch;");
		topLevelClass.addMethod(setFetch);

		Method getFetch = new Method();
		getFetch.setVisibility(JavaVisibility.PUBLIC);
		getFetch.setReturnType(integerWrapper);
		getFetch.setName("getFetch");
		getFetch.addBodyLine("return fetch;");
		topLevelClass.addMethod(getFetch);

		Field offset = new Field();
		offset.setName("offset");
		offset.setVisibility(JavaVisibility.PRIVATE);
		offset.setType(integerWrapper);
		topLevelClass.addField(offset);

		Method setOffset = new Method();
		setOffset.setVisibility(JavaVisibility.PUBLIC);
		setOffset.setName("setOffset");
		setOffset.addParameter(new Parameter(integerWrapper, "offset"));
		setOffset.addBodyLine("this.offset = offset;");
		topLevelClass.addMethod(setOffset);

		Method getOffset = new Method();
		getOffset.setVisibility(JavaVisibility.PUBLIC);
		getOffset.setReturnType(integerWrapper);
		getOffset.setName("getOffset");
		getOffset.addBodyLine("return offset;");
		topLevelClass.addMethod(getOffset);

		return true;
	}*/

	/*@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addLimit(topLevelClass, introspectedTable, "offset");
		addLimit(topLevelClass, introspectedTable, "fetch");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}*/
	
	/**
	 * 為Mapper.xml的selectByExample添加offset
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {

		XmlElement includeElement = new XmlElement("include");
		includeElement.addAttribute(new Attribute("refid", "PageQuerySuffix"));

		element.addElement(includeElement);

		return true;
	}
	
	/**
	 * 在xml文件中添加需要的元素
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		// 產生分頁查詢語句
		XmlElement paginationSuffixElement = new XmlElement("sql");
		paginationSuffixElement.addAttribute(new Attribute("id", "PageQuerySuffix"));
		XmlElement ifOffsetNotNullElement = new XmlElement("if");
		ifOffsetNotNullElement.addAttribute(new Attribute("test", "pageModel.offset != null"));
		ifOffsetNotNullElement.addElement(new TextElement("OFFSET ${pageModel.offset} ROWS FETCH NEXT ${pageModel.fetch} ROWS ONLY"));
		paginationSuffixElement.addElement(ifOffsetNotNullElement);
		
		parentElement.addElement(paginationSuffixElement);
		
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
	/*private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setName(name);
		field.setInitializationString("-1");
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}*/
	
	public static void generate() {  
        String config = SqlServerOffsetPlugin.class.getClassLoader()  
                .getResource("mybatis-generatorConfig.xml").getFile();  
        String[] arg = { "-configfile", config, "-overwrite" };  
        ShellRunner.main(arg);  
    }  
  
    public static void main(String[] args) {  
        generate();  
    }  
}

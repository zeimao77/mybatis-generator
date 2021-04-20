package top.zeimao77.resover;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class MyGenerator extends DefaultCommentGenerator {

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if(introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine("// " + introspectedColumn.getRemarks());
        }
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* mybatis-generator");
        topLevelClass.addJavaDocLine("**/");
    }



}

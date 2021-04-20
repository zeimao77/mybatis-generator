package top.zeimao77.resover;

import java.sql.Types;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 *
 * @author zeimao77
 * 订单中心将smallint 解析为Integer 不要修改
 */
public class MyTypeResolverImpl extends JavaTypeResolverDefaultImpl{

    public MyTypeResolverImpl() {
        super();
        typeMap.remove(Types.SMALLINT);
        typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
        typeMap.put(Types.TINYINT,new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
    }
}


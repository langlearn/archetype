package com.shirokumacafe.archetype.common.mybatis.dialect;
/**
 * A dialect compatible with the H2 database.
 *
 * @author Thomas Mueller
 *
 */
public class H2Dialect extends Dialect {


    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return new StringBuffer(sql.length() + 40).
                append(sql).
                append(hasOffset ? " limit ? offset ?" : " limit ?").
                toString();
    }

    public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit, String limitPlaceholder) {
        return new StringBuffer(sql.length() + 40).
                append(sql).
                append((offset > 0) ? " limit "+limitPlaceholder+" offset "+offsetPlaceholder : " limit "+limitPlaceholder).
                toString();
    }


    @Override
    public String getLimitString(String sql, int skipResults, int maxResults) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
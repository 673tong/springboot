package com.jinkor.utils.datasource.handler;

public class IDynamicDataSourceHandler {

    //写库对应的数据源key
    public static final String MASTER = "master";

    //读库对应的数据源key
    public static final String SLAVE01 = "slave01";
    
    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> SOURCE_LOCAL = new ThreadLocal<String>();

    /**
     * 设置数据源key
     */
    public static void putDataSourceKey(String key) {
    	SOURCE_LOCAL.set(key);
    }
    
    /**
     * 获取数据源key
     */
    public static String getDataSourceKey() {
        return SOURCE_LOCAL.get();
    }
}

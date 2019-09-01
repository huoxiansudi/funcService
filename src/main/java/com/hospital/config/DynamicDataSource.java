package com.hospital.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinhs on 2019-04-19.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static DynamicDataSource instance;
    private static byte[] lock=new byte[0];
    private static Map<Object,Object> dataSourceMap=new HashMap<Object, Object>();

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();// 必须添加该句，否则新添加数据源无法识别到
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dbKey = DatabaseContextHolder.getDBKey();
		/*if (StringUtils.isBlank(dbKey)) {
			dbKey = "read";
		}*/
        return dbKey;
    }

    private DynamicDataSource() {}

    public static synchronized DynamicDataSource getInstance(){
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance=new DynamicDataSource();
                }
            }
        }
        return instance;
    }

}


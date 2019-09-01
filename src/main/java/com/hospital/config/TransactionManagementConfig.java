package com.hospital.config;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * User: xiaofu
 * Date: 2018-5-31
 * Time: 15:48
 * Function:
 */
//@Configuration
public class TransactionManagementConfig implements TransactionManagementConfigurer {

    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}

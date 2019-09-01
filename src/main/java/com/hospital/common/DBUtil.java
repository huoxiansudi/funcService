package com.hospital.common;

import java.sql.*;

/**
 * User: xiaofu
 * Date: 2017/9/4
 * Time: 18:23
 * Function: 原始jdbc链接数据库
 */
public class DBUtil {

    private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
    private static final String jdbcUrl = "jdbc:oracle:thin:@192.168.0.1:1521:orcl";
    private static final String user = "zjhis";
    private static final String password = "zjhis";

    public static Connection getConn() {

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 关闭连接(数据库连接对象)
     *
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭编译的 SQL 语句的对象
     *
     * @param stmt
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集
     *
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     *
     * @param conn
     */
    public static void commit(Connection conn) {
        try {
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     *
     * @param conn
     */
    public static void rollback(Connection conn) {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class gbks {
        private String id;
        private String ksbm;
        private String ksmc;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKsbm() {
            return ksbm;
        }

        public void setKsbm(String ksbm) {
            this.ksbm = ksbm;
        }

        public String getKsmc() {
            return ksmc;
        }

        public void setKsmc(String ksmc) {
            this.ksmc = ksmc;
        }
    }

}

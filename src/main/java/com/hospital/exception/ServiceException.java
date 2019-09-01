package com.hospital.exception;

/**
 * Created by fuxf on 2017/8/3.
 */
public class ServiceException   extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}

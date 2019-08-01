package com.work.idworker;

import java.io.Serializable;

/**
 * Program Name: Ground
 * <p>
 * Description: 基础异常
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2018/7/6 11:23 PM
 */
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4031257468502262262L;


    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}


package com.work.idworker;

/**
 * Program Name: Ground
 * <p>
 * Description: ID生成器异常
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2018/7/6 11:23 PM
 */
public class IDWorkerException extends BaseException {

    private static final long serialVersionUID = -329087741208425060L;

    public IDWorkerException() {
        super();
    }

    public IDWorkerException(String message) {
        super(message);
    }

    public IDWorkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public IDWorkerException(Throwable cause) {
        super(cause);
    }
}

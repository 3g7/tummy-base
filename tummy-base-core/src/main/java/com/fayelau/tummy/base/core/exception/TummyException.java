package com.fayelau.tummy.base.core.exception;

import java.text.MessageFormat;

/**
 * 
 * 自定义异常
 * 
 * @author 3g7 2019-09-06 23:56:04
 * @version 0.0.1
 *
 */
public class TummyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    
    public Integer getCode() {
        return code;
    }

    /**
     * 只接收一个错误信息私有构造函数
     * 
     * @param errMessage
     */
    private TummyException(String errMessage) {
        super(errMessage);
    }

    /**
     * 只接收一个错误信息私有构造函数
     * 
     * @param errMessage
     */
    private TummyException(String errMessage, Integer code) {
        super(errMessage);
        this.code = code;
    }

    /**
     * 接收内部异常与错误信息的私有构造函数
     * 
     * @param innerException
     * @param errMessage
     */
    private TummyException(Exception innerException, String errMessage) {
        super(errMessage, innerException);
    }

    /**
     * 接收内部异常与错误信息的私有构造函数
     * 
     * @param innerException
     * @param errMessage
     */
    private TummyException(Exception innerException, String errMessage, Integer code) {
        super(errMessage, innerException);
        this.code = code;
    }

    /**
     * 通过错误代码获取一个自定义异常
     * 
     * @param code
     * @return
     */
    public static TummyException getException(Integer code) {
        String errMessage = TummyExCode.code2ErrorMessage(code);
        return new TummyException(errMessage, code);
    }

    /**
     * 通过错误代码获取一个自定义异常，如果错误信息的模板拥有占位符，第二个Object数组会填入其中
     * 
     * @param code
     * @param lstPattern
     * @return
     */
    public static TummyException getException(Integer code, Object... lstPattern) {
        String errMessageTemp = TummyExCode.code2ErrorMessage(code);
        String errMessage = MessageFormat.format(errMessageTemp, lstPattern);
        return new TummyException(errMessage, code);
    }

    /**
     * 通过内部异常和错误代码获取一个自定义异常
     * 
     * @param innerException
     * @param code
     * @return
     */
    public static TummyException getException(Exception innerException, Integer code) {
        String errMessage = TummyExCode.code2ErrorMessage(code);
        return new TummyException(innerException, errMessage, code);
    }

    /**
     * 通过内部异常和错误信息获取一个自定义异常
     * 
     * @param innerException
     * @param errMessage
     * @return
     */
    public static TummyException getException(Exception innerException, String errMessage) {
        return new TummyException(innerException, errMessage);
    }

    /**
     * 通过内部异常，错误代码，和模板参数获取一个自定义异常
     * 
     * @param innerException
     * @param code
     * @param arguments
     * @return
     */
    public static TummyException getException(Exception innerException, Integer code, Object... arguments) {
        String errMessageTemp = TummyExCode.code2ErrorMessage(code);
        String errMessage = MessageFormat.format(errMessageTemp, arguments);
        return new TummyException(innerException, errMessage, code);
    }

}

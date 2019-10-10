package com.fayelau.tummy.base.core.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 异常代码常量
 * 
 * @author 3g7 2019-09-07 00:10:33
 * @version 0.0.1
 *
 */
public class TummyExCode {

    // 未知错误
    public static final Integer UNKNOWN_ERROR = -9999;
    // 参数为空
    public static final Integer PARAMETER_NULL = -1001;
    // 参数错误
    public static final Integer PARAMETER_ERROR = -1002;
    // 参数错误
    public static final Integer PARSE_ERROR = -1003;

    // 错误信息对应配置路径 以包路径查找
    //private static final String CONFIG_PATH = "com/fayelau/tummy/base/core/exception/ErrorMessage";
    private static final String CONFIG_NAME = "ErrorMessage";

    // 位置错误信息
    private static final String UNKNOWN_ERROR_MESSAGE = "系统未知错误";

    // 错误信息模板
    private static final String ERROR_MESSAGE_TEMP = "[{0}] {1}";

    /**
     * 异常编码转错误信信
     * 
     * @param code
     * @return
     */
    public static String code2ErrorMessage(Integer code) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle(CONFIG_NAME);
            String message = resource.getString(code.toString());
            return MessageFormat.format(ERROR_MESSAGE_TEMP, code.toString(), message);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageFormat.format(ERROR_MESSAGE_TEMP, UNKNOWN_ERROR.toString(), UNKNOWN_ERROR_MESSAGE);
        }

    }

}

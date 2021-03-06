package cn.edu.buaa.tricloud.mooc.Response;

/**
 * Created by qixiang on 8/19/17.
 */
public class ResponseCodeMessage {

    public static final int OK_CODE = 0;
    public static final String OK_MESSAGE = "success";

    public static final int ERROR_CODE = -1;
    public static final String ERROR_MESSAGE = "error";

    public static final int ACCOUNT_NOT_FOUND_CODE = -2;
    public static final String ACCOUNT_NOT_FOUND_MESSAGE = "failure to find the account";

    public static final int ACCOUNT_DUPLICATE_CODE = -3;
    public static final String ACCOUNT_DUPLICATE_MESSAGE = "account is duplicate";

    public static final int QUERY_PARAMETERS_ERROR_CODE = -4;
    public static final String QUERY_PARAMETERS_ERROR_MESSAGE = "query parameters error";

    public static final int COURSE_NOT_FOUND_CODE = -5;
    public static final String COURSE_NOT_FOUND_MESSAGE = "failure to find the course";

    public static final int ACCOUNT_ROLE_NONVALIDATE_CODE = -6;
    public static final String ACCOUNT_ROLE_NONVALIDATE_MESSAGE = "account's role is nonvalidate";

    public static final int ACCOUNT_PASSWORD_ERROR_CODE = -7;
    public static final String ACCOUNT_PASSWORD_ERROR_MESSAGE = "user's password is not correct";

    public static final int ATTACHMENT_UPLOAD_ERROR_CODE = -8;

    public static final int RESOURCE_NOT_FOUND_CODE = -9;

    public static final int RESOURCE_NOT_IN_COURSE_CODE = -10;

    public static final int COURSE_ORDER_NOT_FOUND_CODE = -11;

    public static final int MACHINE_OPERATOR_ERROR_CODE = -12;

    public static final int ACTION_NOT_SUPPORTED_CODE = -13;

    public static final int ACTION_NOT_FOUND_CODE = -14;

    public static final int COURSE_ORDER_ALREADY_ORDERED = -15;
}

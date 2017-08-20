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


}

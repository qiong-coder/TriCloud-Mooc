package cn.edu.buaa.tricloud.mooc.exception;

/**
 * Created by qixiang on 8/19/17.
 */
public class RuntimeExceptionWithErrorCode extends RuntimeException {

    private int code;

    public RuntimeExceptionWithErrorCode(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

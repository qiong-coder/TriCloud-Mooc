package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by stupid-coder on 8/22/17.
 */
public class MachineOperatorError extends RuntimeExceptionWithErrorCode {

    public MachineOperatorError(String message) {
        super(message, ResponseCodeMessage.MACHINE_OPERATOR_ERROR_CODE);
    }
}

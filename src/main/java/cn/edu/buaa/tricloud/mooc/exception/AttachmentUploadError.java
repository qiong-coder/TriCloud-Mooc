package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/20/17.
 */
public class AttachmentUploadError extends RuntimeExceptionWithErrorCode {

    public AttachmentUploadError(String message) {
        super(message, ResponseCodeMessage.ATTACHMENT_UPLOAD_ERROR_CODE);
    }

}

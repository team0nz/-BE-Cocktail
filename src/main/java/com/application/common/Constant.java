package com.application.common;

public class Constant {
    public final static String UPLOAD_DIR = "src/main/java/com/application/uploads/";


    public final static Integer SUCCESS_CODE = 1;
    public final static Integer NEED_REFRESH_TOKEN_CODE = -2;
    public final static Integer ERROR_CODE = -1;

    public final static Long REFRESH_EXPIRED_TIME = 14*24*60*60L;
    public final static Long BLACKLIST_EXPIRED_TIME = 15 * 60L;
}
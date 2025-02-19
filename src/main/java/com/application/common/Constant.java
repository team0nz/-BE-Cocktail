package com.application.common;

public class Constant {
    public final static String UPLOAD_DIR = "src/main/java/com/application/uploads/";


    public final static int SUCCESS_CODE = 1;
    public final static int NEED_REFRESH_TOKEN_CODE = -2;
    public final static int ERROR_CODE = -1;

    public final static long REFRESH_EXPIRED_TIME = 14*24*60*60L;
    public final static long BLACKLIST_EXPIRED_TIME = 15 * 60L;
}
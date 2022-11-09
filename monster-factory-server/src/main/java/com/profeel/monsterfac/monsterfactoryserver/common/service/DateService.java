package com.profeel.monsterfac.monsterfactoryserver.common.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * Class : DateService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class DateService {

    public static String getCurrentDatetimeWithFormating(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        Date now = new Date();
        return format.format(now);
    }

}

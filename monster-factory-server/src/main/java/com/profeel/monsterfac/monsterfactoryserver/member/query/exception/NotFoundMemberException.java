package com.profeel.monsterfac.monsterfactoryserver.member.query.exception;


/**
 * <pre>
 * Class : NotFoundMemberException
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
public class NotFoundMemberException extends RuntimeException {
    public NotFoundMemberException(String msg) {super(msg);}
}

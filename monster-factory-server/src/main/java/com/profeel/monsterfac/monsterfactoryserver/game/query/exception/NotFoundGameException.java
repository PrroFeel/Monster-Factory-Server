package com.profeel.monsterfac.monsterfactoryserver.game.query.exception;


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
public class NotFoundGameException extends RuntimeException {
    public NotFoundGameException(String msg) {super(msg);}
}

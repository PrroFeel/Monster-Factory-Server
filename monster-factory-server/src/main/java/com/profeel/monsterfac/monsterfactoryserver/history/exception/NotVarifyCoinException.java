package com.profeel.monsterfac.monsterfactoryserver.history.exception;

/**
 * <pre>
 * Class : NotVarifyCoinException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public class NotVarifyCoinException extends RuntimeException {
    public NotVarifyCoinException(String message) {
        super(message);
    }
}

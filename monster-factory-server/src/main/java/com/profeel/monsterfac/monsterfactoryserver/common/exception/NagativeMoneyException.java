package com.profeel.monsterfac.monsterfactoryserver.common.exception;

/**
 * <pre>
 * Class : NagativeMoneyException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public class NagativeMoneyException extends RuntimeException{
    public NagativeMoneyException(String message) {
        super(message);
    }
}

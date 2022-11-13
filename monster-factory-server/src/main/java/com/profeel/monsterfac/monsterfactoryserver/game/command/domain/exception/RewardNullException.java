package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.exception;

/**
 * <pre>
 * Class : NotFoundProjectException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class RewardNullException extends RuntimeException {
    public RewardNullException(String msg){
        super(msg);
    }
}

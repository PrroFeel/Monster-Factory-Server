package com.profeel.monsterfac.monsterfactoryserver.game.command.application.exception;

/**
 * <pre>
 * Class : RewardItemQuantityException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class RewardItemQuantityException extends RuntimeException{
    public RewardItemQuantityException(String msg){
        super(msg);
    }
}

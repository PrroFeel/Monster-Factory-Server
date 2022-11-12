package com.profeel.monsterfac.monsterfactoryserver.item.command.application.exception;

/**
 * <pre>
 * Class : NotFoundItemException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */


public class NotFoundItemException extends RuntimeException {

    public NotFoundItemException(String msg){
        super(msg);
    }
}

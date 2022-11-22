package com.profeel.monsterfac.monsterfactoryserver.tower.query.exception;

/**
 * <pre>
 * Class : NotFoundTowerException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class NotFoundTowerException extends RuntimeException{
    public NotFoundTowerException(String message) {
        super(message);
    }
}

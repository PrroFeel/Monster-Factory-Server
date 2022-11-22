package com.profeel.monsterfac.monsterfactoryserver.file.command.application.exception;

/**
 * <pre>
 * Class : AlreadyDeletedFileException
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
 * @see 참고할 class 또는 외부 url
 */
public class AlreadyDeletedFileException extends RuntimeException{
    public AlreadyDeletedFileException(String message) {
        super(message);
    }
}

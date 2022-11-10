package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.exception;

/**
 * <pre>
 * Class : ItemPriceException
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class ItemPriceException extends RuntimeException {

    public ItemPriceException(String message) {
        super(message);
    }
}

package com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model;

/**
 * <pre>
 * Class : Result
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
 * @see 참고할 class 또는 외부 url
 */
public enum Result {
    APPROVED, RETURNED;

    public static Result fromString(String state) {
        switch (state) {
            case "RETURNED": return RETURNED;
            case "APPROVED": return APPROVED;
            default: return null;
        }
    }
}

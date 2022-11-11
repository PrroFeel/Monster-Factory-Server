package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

/**
 * <pre>
 * Class : GameStatus
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
public enum GameStatus {
    JUDGE_WAIT, RETURNED, APPROVED, UPLOADED;

    public static GameStatus fromString(String state) {
        switch(state) {
            case "JUDGE_WAIT": return JUDGE_WAIT;
            case "RETURNED": return RETURNED;
            case "APPROVED" : return APPROVED;
            case "UPLOADED" : return UPLOADED;
            default: return null;
        }
    }
}

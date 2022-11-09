package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

/**
 * <pre>
 * Class : ProjectSatus
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public enum ProjectStatus {
    PRE, IN_PROGRESS, DONE;

    public static ProjectStatus fromString(String state) {
        switch(state) {
            case "PRE": return PRE;
            case "IN_PROGRESS": return IN_PROGRESS;
            case "DOME" : return DONE;
            default: return null;
        }
    }
}

package com.profeel.monsterfac.monsterfactoryserver.common.dto;

/**
 * <pre>
 * Class : ResponseDto
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class ResponseDTO {
    private int status;     // 상태 코드
    private String message; // 메세지
    private Object results; // 결과 데이터

    public ResponseDTO() {}

    public ResponseDTO(int status, String message, Object results) {
        this.status = status;
        this.message = message;
        this.results = results;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "statue=" + status +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }
}

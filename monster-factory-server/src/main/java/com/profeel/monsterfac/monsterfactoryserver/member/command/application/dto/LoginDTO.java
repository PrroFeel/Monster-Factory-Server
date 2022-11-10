package com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto;


import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Password;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * <pre>
 * Class : LoginDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-07       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */
public class LoginDTO {

    @ApiModelProperty(value="사용자의 이름", example = "프로필")
    private String memberId;

    @ApiModelProperty(value="사용자의 비밀번호", example = "Profeel123!")
    private Password password;

    public LoginDTO(String memberId, Password password) {
        this.memberId = memberId;
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

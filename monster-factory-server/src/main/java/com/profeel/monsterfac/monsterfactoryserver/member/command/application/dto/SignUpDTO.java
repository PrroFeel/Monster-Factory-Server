package com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * <pre>
 * Class : SignUpDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class SignUpDTO {

    @ApiModelProperty(value="사용자의 이름", example = "홍길동")
    @NotBlank(message = "닉네임을 입력해 주세요")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상, 10자 이하로 입력해 주세요")
    private String memberId;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Size(min = 10, message = "비밀번호는 10자 이상으로 작성해 주세요")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @ApiModelProperty(value="사용자의 성별", example = "남")
    private String gender;

    @ApiModelProperty(value="사용자의 생일", example = "2022-11-10")
    private Date birthday;

    public SignUpDTO(String memberId, String password, String gender, Date birthday) {
        this.memberId = memberId;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "memberId=" + memberId +
                ", password=" + password +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

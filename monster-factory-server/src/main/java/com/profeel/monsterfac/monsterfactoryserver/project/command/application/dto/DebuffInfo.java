package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * <pre>
 * Class : DebuffInfo
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class DebuffInfo {
    @ApiModelProperty(value = "디버프 이름", example = "느려짐")
    @JsonProperty("debuff_name")
    private String debuffName;

    @ApiModelProperty(value = "배치 위치", example = "[0,0,0]")
    @JsonProperty("debuff_position")
    private Float[] debuffPosition;

    protected DebuffInfo(){}

    public String getDebuffName() {
        return debuffName;
    }

    public void setDebuffName(String debuffName) {
        this.debuffName = debuffName;
    }

    public Float[] getDebuffPosition() {
        return debuffPosition;
    }

    public void setDebuffPosition(Float[] debuffPosition) {
        this.debuffPosition = debuffPosition;
    }

    @Override
    public String toString() {
        return "DebuffInfo{" +
                "debuffName='" + debuffName + '\'' +
                ", debuffPosition=" + Arrays.toString(debuffPosition) +
                '}';
    }
}

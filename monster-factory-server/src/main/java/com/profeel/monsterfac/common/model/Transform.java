package com.profeel.monsterfac.common.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * <pre>
 * Class : Transform
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

public class Transform {

    @JsonProperty("position")
    private float[] position;

    @JsonProperty("rotation")
    private float[] rotation;

    @JsonProperty("scale")
    private float[] scale;

    @JsonProperty("mats")
    private String[] mats;

    protected Transform() {}

    public Transform( float[] position, float[] rotation, float[] scale, String[] mats) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        this.mats = mats;
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                ", position=" + Arrays.toString(position) +
                ", rotation=" + Arrays.toString(rotation) +
                ", scale=" + Arrays.toString(scale) +
                ", mats=" + Arrays.toString(mats) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transform that = (Transform) o;
        return Arrays.equals(position, that.position) && Arrays.equals(rotation, that.rotation) && Arrays.equals(scale, that.scale) && Arrays.equals(mats, that.mats);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(position);
        result = 31 * result + Arrays.hashCode(rotation);
        result = 31 * result + Arrays.hashCode(scale);
        result = 31 * result + Arrays.hashCode(mats);
        return result;
    }
}
package com.profeel.monsterfac.monsterfactoryserver.common.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profeel.monsterfac.monsterfactoryserver.common.model.Transform;

import javax.persistence.AttributeConverter;

/**
 * <pre>
 * Class : ObjectInfoConvertor
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
public class TransformConvertor implements AttributeConverter<Transform, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @Override
    public String convertToDatabaseColumn(Transform objectInfo) {
        try {
            return objectMapper.writeValueAsString(objectInfo);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("error log:  ");
        }
    }

    @Override
    public Transform convertToEntityAttribute(String data) {
        try {
            return objectMapper.readValue(data, Transform.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("error log:  ");
        }
    }
}
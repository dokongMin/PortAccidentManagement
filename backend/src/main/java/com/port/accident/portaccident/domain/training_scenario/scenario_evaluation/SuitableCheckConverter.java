package com.port.accident.portaccident.domain.training_scenario.scenario_evaluation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.List;

public class SuitableCheckConverter implements AttributeConverter<List<SuitableCheck>, String> {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

    @Override
    public String convertToDatabaseColumn(List<SuitableCheck> attribute) { // enum을 DB에 어떤 값으로 넣을 것인지 정의
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<SuitableCheck> convertToEntityAttribute(String dbData) { //  DB에서 읽힌 값에 따라 어떻게 enum랑 매칭 시킬 것인지 정의
        try {
            return mapper.readValue(dbData, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}

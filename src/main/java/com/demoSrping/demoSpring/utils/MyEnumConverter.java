package com.demoSrping.demoSpring.utils;

import com.demoSrping.demoSpring.entity.enums.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MyEnumConverter implements AttributeConverter<Color, String> {
    @Override
    public String convertToDatabaseColumn(Color color) {
        return (color != null)? String.valueOf(color) : null;
    }

    @Override
    public Color convertToEntityAttribute(String code) {
        return (code != null)? Color.valueOf(code): null;
    }
}

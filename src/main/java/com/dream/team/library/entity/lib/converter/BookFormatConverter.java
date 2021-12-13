package com.dream.team.library.entity.lib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BookFormatConverter implements AttributeConverter<BookFormat, String> {
    @Override
    public String convertToDatabaseColumn(BookFormat bookFormat) {
        if (bookFormat == null) {
            return null;
        }

        return bookFormat.getFormat();
    }

    @Override
    public BookFormat convertToEntityAttribute(String format) {
        if (format == null) {
            return null;
        }

        return Stream.of(BookFormat.values())
                .filter(bf -> bf.getFormat().equals(format))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

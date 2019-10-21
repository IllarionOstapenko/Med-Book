//package com.book.medecinebook.confins;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormatter;
//import org.joda.time.format.ISODateTimeFormat;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class JsonJodaDateTimeSerializer extends JsonSerializer<DateTime> {
//
//    private static DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
//
//    @Override
//    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers)
//            throws IOException, JsonProcessingException {
//        System.out.println("fghjkjhgfghjk");
//        gen.writeString(formatter.print(value));
//    }
//}

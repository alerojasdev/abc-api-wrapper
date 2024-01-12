package com.ale.abcapiimplementation.service;

import com.ale.abcapiimplementation.dto.RequestedNewsData;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextConverter extends AbstractHttpMessageConverter<ArrayList<RequestedNewsData>> {

    public TextConverter() {
        super(MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ArrayList.class);
    }

    @Override
    protected ArrayList readInternal(Class<? extends ArrayList<RequestedNewsData>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        throw new RuntimeException("Not implemented");
    }

    @Override
    protected void writeInternal(ArrayList<RequestedNewsData> requestedNewsData, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        String textPlain = requestedNewsData.stream().map(i->i.toText()).collect(Collectors.joining("\r\n\r\n"));

        OutputStreamWriter writer = new OutputStreamWriter(outputMessage.getBody(), Charset.defaultCharset());
        writer.write(textPlain);
        writer.flush();

    }
}

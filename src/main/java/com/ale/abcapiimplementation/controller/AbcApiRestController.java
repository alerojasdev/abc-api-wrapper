package com.ale.abcapiimplementation.controller;

import com.ale.abcapiimplementation.entity.ErrorBodyMessage;
import com.ale.abcapiimplementation.entity.NewsMetaData;
import com.ale.abcapiimplementation.rest.AbcApiWrap;
import com.ale.abcapiimplementation.rest.Base64Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abc-api-implementation")
public class AbcApiRestController {
    @Autowired
    AbcApiWrap abcApiWrap;
    @Autowired
    Base64Converter base64Converter;
    @GetMapping(value = "/consulta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE})
    private ResponseEntity getAbcInfo(@RequestParam(name = "requestInfo", required=false) String requestInfo, @RequestParam(name = "f", required = false) boolean f){

        try {
            if (requestInfo == null || requestInfo.isEmpty() || requestInfo.isBlank()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorBodyMessage("g268","Parámetros inválidos"));
            }

            List<NewsMetaData> newsMetaData =  abcApiWrap.getAbcNewsData(requestInfo);

            if (f){
                for (NewsMetaData dto : newsMetaData){
                    dto.setContenido_foto(base64Converter.imageUrlToBase64String(dto.getEnlace_foto()));

                }
            }

            if (newsMetaData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorBodyMessage("g267", "No se encuentran noticias para el texto: {" + requestInfo + "}"));
            } else {
                return ResponseEntity.ok(newsMetaData);
            }

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorBodyMessage("g100", "Error interno del servidor"));
        }
    }
}
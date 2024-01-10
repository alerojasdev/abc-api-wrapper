package com.ale.abcapiimplementation.controller;

import com.ale.abcapiimplementation.entity.ErrorBodyMessage;
import com.ale.abcapiimplementation.entity.NewsMetaData;
import com.ale.abcapiimplementation.rest.AbcApiWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abc-api-implementation")
public class AbcApiRestController {
    @Autowired
    AbcApiWrap abcApiWrap;
    @GetMapping(value = "/consulta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private ResponseEntity getAbcInfo(@RequestParam(name = "requestInfo") String requestInfo){

        try {
            if (requestInfo == null || requestInfo.isEmpty() || requestInfo.isBlank()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorBodyMessage("g268","Parámetros inválidos"));
            }

            NewsMetaData newsMetaData =  abcApiWrap.getAbcNewsData(requestInfo);
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
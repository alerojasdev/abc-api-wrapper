package com.ale.abcapiimplementation.controller;

import com.ale.abcapiimplementation.dto.ErrorBodyMessage;
import com.ale.abcapiimplementation.dto.RequestedNewsData;
import com.ale.abcapiimplementation.service.AbcApiWrap;
import com.ale.abcapiimplementation.service.Base64Converter;
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
    @GetMapping(
            value = "/consulta",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.TEXT_PLAIN_VALUE,
                    MediaType.TEXT_HTML_VALUE
            }
    )
    private ResponseEntity getAbcInfo(
            @RequestParam(name = "requestInfo", required=false)
            String requestInfo,
            @RequestParam(name = "f", required = false)
            Boolean base64Requested
    ){
        try {

            if (requestInfo == null || requestInfo.isEmpty() || requestInfo.isBlank()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorBodyMessage("g268","Parámetros inválidos"));
            }

            List<RequestedNewsData> requestedNewsData =  abcApiWrap.getAbcNewsData(requestInfo);

            if (Boolean.FALSE.equals(base64Requested)){
                for (RequestedNewsData dto : requestedNewsData){
                    dto.setContenido_foto(base64Converter.imageUrlToBase64String(dto.getEnlace_foto()));
                }
            }

            if (requestedNewsData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorBodyMessage("g267", "No se encuentran noticias para el texto: {" + requestInfo + "}"));
            } else {
                return ResponseEntity.ok(requestedNewsData);
            }

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorBodyMessage("g100", "Error interno del servidor"));
        }
    }
}
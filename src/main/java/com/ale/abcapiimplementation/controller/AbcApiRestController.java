package com.ale.abcapiimplementation.controller;

import com.ale.abcapiimplementation.entity.AbcInformationContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/abc-api-implementation")
public class AbcApiRestController {

    @GetMapping("/consulta/{requestInfo}")
    private ResponseEntity<List<AbcInformationContent>> getAbcInfo(@RequestParam String requestInfo){

        List<AbcInformationContent> abcListInfo = new ArrayList<>();

        abcListInfo.add(new AbcInformationContent("www.abc.com.py/noticia1", "www.abc.com.py/photo-noticia1", "titulo Noticia 1", "noticia1 Resumen"));
        abcListInfo.add(new AbcInformationContent("www.abc.com.py/noticia2", "www.abc.com.py/photo-noticia2", "titulo Noticia 2", "noticia2 Resumen"));
        abcListInfo.add(new AbcInformationContent("www.abc.com.py/noticia3", "www.abc.com.py/photo-noticia3", "titulo Noticia 3", "noticia3 Resumen"));
        abcListInfo.add(new AbcInformationContent("www.abc.com.py/noticia4", "www.abc.com.py/photo-noticia4", "titulo Noticia 4", "noticia4 Resumen"));

        return ResponseEntity.ok(abcListInfo);

    }

}
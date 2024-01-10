package com.ale.abcapiimplementation.controller;

import com.ale.abcapiimplementation.entity.AbcInformationContent;
import com.ale.abcapiimplementation.rest.AbcApiWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/abc-api-implementation")
public class AbcApiRestController {
    @Autowired
    AbcApiWrap abcApiWrap;
    @GetMapping(value = "/consulta", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.ALL_VALUE)
    private ResponseEntity<List<AbcInformationContent>> getAbcInfo(@RequestParam(name = "requestInfo") String requestInfo) throws URISyntaxException, IOException, InterruptedException {

        List<AbcInformationContent> arrayData = abcApiWrap.getAbcNewsData();

        return ResponseEntity.ok(arrayData);
    }
}
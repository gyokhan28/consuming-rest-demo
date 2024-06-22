package com.example.consuming_rest_apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CatFactController {

    private final CatFactService catFactService;
    private final CatClient client;
    private final PostClient postClient;

    @Autowired
    public CatFactController(CatFactService catFactService, CatClient client, PostClient postClient) {
        this.catFactService = catFactService;
        this.client = client;
        this.postClient = postClient;
    }


    @GetMapping("/cat-fact")
    public String getCatFact() throws IOException {
        return catFactService.getCatFact();
    }

    @PostMapping("/post")
    public String postCatFact(@RequestBody CatFact catFact) throws IOException {
        return catFactService.postCatFact(catFact);
    }

    @GetMapping("/info")
    public ResponseEntity<CatFact> getCatFactAndSave(){
        CatFact catFact = client.getCatFact();
        catFactService.saveFact(catFact.getFact());
        return ResponseEntity.ok(catFact);
    }

    @PostMapping("/add-cat-fact")
    public ResponseEntity<String> postCatFactAndSave(@RequestBody CatFact catFact) {
        postClient.postCatFact(catFact);
        catFactService.saveFact(catFact.getFact());
        return ResponseEntity.ok("Successfully saved new fact :" + catFact.getFact());
    }

}

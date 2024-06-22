package com.example.consuming_rest_apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "post-client", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostClient {

    @PostMapping("/")
    void postCatFact(CatFact catFact);
}

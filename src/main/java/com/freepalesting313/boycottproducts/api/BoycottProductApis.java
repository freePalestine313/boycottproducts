package com.freepalesting313.boycottproducts.api;

import com.freepalesting313.boycottproducts.dataservices.GitHubDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/boycott/")
public class BoycottProductApis {

    @Autowired
    private GitHubDataFetcher gitHubDataFetcher;

    @Autowired
    

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    String createAppUser() {
        return gitHubDataFetcher.fetchDataFromGitHub();
    }

}

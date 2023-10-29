package com.freepalesting313.boycottproducts.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freepalesting313.boycottproducts.dataservices.GitHubDataFetcher;
import com.freepalesting313.boycottproducts.dto.BoycottProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoycottService {

    @Autowired
    private GitHubDataFetcher gitHubDataFetcher;

    @Autowired
    private ObjectMapper objectMapper;

    public List<BoycottProduct> boycottProductList(){
        String boycottProductStr = gitHubDataFetcher.fetchDataFromGitHub();
        TypeReference<List<BoycottProduct>> listTypeReference = new TypeReference<List<BoycottProduct>>() {};
        List<BoycottProduct> boycottProductList = null;
        try {
            boycottProductList = objectMapper.readValue(boycottProductStr,listTypeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return boycottProductList;
    }
}

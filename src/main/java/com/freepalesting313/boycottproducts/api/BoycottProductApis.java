package com.freepalesting313.boycottproducts.api;

import com.freepalesting313.boycottproducts.dto.BoycottProduct;
import com.freepalesting313.boycottproducts.service.BoycottService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/boycott/")
public class BoycottProductApis {

    @Autowired
    BoycottService boycottService;

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    List<BoycottProduct> createAppUser() {
        return boycottService.boycottProductList();
    }

}

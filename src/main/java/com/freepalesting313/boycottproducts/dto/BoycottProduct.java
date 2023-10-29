package com.freepalesting313.boycottproducts.dto;

import com.freepalesting313.boycottproducts.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoycottProduct{
    private String product;
    private Category category;
    private List<String> synonyms;
    private String contributor;
    private List<String> source;
}
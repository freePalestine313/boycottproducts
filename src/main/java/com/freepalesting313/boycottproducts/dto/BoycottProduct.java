package com.freepalesting313.boycottproducts.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoycottProduct{
    public String product;
    public List<String> source;
}
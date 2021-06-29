package com.github.jwxa.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PicDataRespDTO {

    private String pid;

    private String title;

    private List<Map<String,String>> urls;

}

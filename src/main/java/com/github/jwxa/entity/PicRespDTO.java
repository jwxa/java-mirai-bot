package com.github.jwxa.entity;

import lombok.Data;

import java.util.List;

@Data
public class PicRespDTO {

    private String error;

    private List<PicDataRespDTO> data;

}

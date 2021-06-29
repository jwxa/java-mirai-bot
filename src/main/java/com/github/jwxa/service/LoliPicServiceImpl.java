package com.github.jwxa.service;

import com.alibaba.fastjson.JSONObject;
import com.github.jwxa.entity.PicRespDTO;
import com.github.jwxa.interfaces.ILoliPicService;
import com.github.jwxa.utils.HttpClientUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoliPicServiceImpl implements ILoliPicService {

    @Override
    public Optional<String> getPicUrl() {
        String resp = HttpClientUtil.doGet("https://api.lolicon.app/setu/v2?size=regular");
        PicRespDTO picRespDTO = JSONObject.parseObject(resp, PicRespDTO.class);
        if (Objects.nonNull(picRespDTO) && CollectionUtils.isNotEmpty(picRespDTO.getData())) {
            List<Map<String, String>> urlMapList = picRespDTO.getData().get(0).getUrls();
            Map<String, String> urlMap = urlMapList.get(0);
            String url = urlMap.get("regular");
            if (StringUtils.isBlank(url)) {
                return Optional.empty();
            }
            return Optional.of(url);
        }
        return Optional.empty();
    }

}

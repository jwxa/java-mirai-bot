package com.github.jwxa.service;


import com.alibaba.fastjson.JSONObject;
import com.github.jwxa.entity.PicRespDTO;
import com.github.jwxa.interfaces.ILoliPicService;
import com.github.jwxa.utils.HttpClientUtil;
import com.zhuangxv.bot.annotation.FriendMessageHandler;
import com.zhuangxv.bot.message.MessageChain;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class FriendMessageServiceImpl {

    @Autowired
    private ILoliPicService loliPicService;

    @FriendMessageHandler(senderId = 171413094)
    public MessageChain loli(String msg) {
        System.out.println(msg);
        if ("st".equals(msg)) {
            Optional<String> picUrl = loliPicService.getPicUrl();
            if (picUrl.isPresent()) {
                MessageChain messageChain = new MessageChain();
                messageChain.image(picUrl.get());
                return messageChain;
            }
        }
        return null;
    }

}

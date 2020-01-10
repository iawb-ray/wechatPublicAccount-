package com.zhoumin.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhoumin.wechat.common.MessageLog;
import com.zhoumin.wechat.service.MessageLogService;

import java.util.List;

/**
 * @Author: Ray
 * @Date: 2020/1/10
 */
@RestController
public class MessageLogController {

    @Autowired
    private MessageLogService messageLogService;

    @RequestMapping(value = "/allMessageLog")
    public List<MessageLog> getMessageLog(){
        return messageLogService.getMessageLog();
    }

    @RequestMapping(value = "/insertMessageLog")
    public MessageLog insertMessageLog(MessageLog messageLog){
        messageLogService.insertMessageLog(messageLog);
        return messageLog;
    }
}

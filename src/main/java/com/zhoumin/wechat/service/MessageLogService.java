package com.zhoumin.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhoumin.wechat.common.MessageLog;
import com.zhoumin.wechat.mapper.MessageLogMapper;

import java.util.List;

/**
 * @Author: Ray
 * @Date: 2020/1/10
 */
@Service
public class MessageLogService {

    @Autowired
    private MessageLogMapper messageLogMapper;

    public List<MessageLog> getMessageLog(){
        return messageLogMapper.getMessageLog();
    }

    public int insertMessageLog(MessageLog messageLog){
        return messageLogMapper.insertMessageLog(messageLog);
    }
}

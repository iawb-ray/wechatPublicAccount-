package com.zhoumin.wechat.mapper;

import com.zhoumin.wechat.common.MessageLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Ray
 * @Date: 2020/1/10
 */
public interface MessageLogMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO `oldwang`.`MessageLog`( `fromUserName`, `toUserName`, `msgType`, `content`, `datetime`) VALUES (#{fromUserName},#{toUserName}, #{msgType}, #{content}, #{datetime})")
    public int insertMessageLog(MessageLog messageLog);

    @Select("select * from messagelog")
    public List<MessageLog> getMessageLog();
}

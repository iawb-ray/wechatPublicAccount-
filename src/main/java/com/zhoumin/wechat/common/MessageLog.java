package com.zhoumin.wechat.common;

import java.time.LocalDateTime;

/**
 * 消息日志类
 * @author Ray
 */
public class MessageLog {
    private Integer id;
    private String fromUserName;
    private String toUserName;
    private String msgType;
    private String content;
    private LocalDateTime datetime;

    @Override
    public String toString() {
        return "MessageLog{" +
                "id=" + id +
                ", fromUserName='" + fromUserName + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public MessageLog() {
    }

    public MessageLog(Integer id, String fromUserName, String toUserName, String msgType, String content, LocalDateTime datetime) {
        this.id = id;
        this.fromUserName = fromUserName;
        this.toUserName = toUserName;
        this.msgType = msgType;
        this.content = content;
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}

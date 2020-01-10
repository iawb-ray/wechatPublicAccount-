package com.zhoumin.wechat.service.impl;

import com.zhoumin.wechat.common.MessageLog;
import com.zhoumin.wechat.message.Article;
import com.zhoumin.wechat.message.NewsMessage;
import com.zhoumin.wechat.message.TextMessage;
import com.zhoumin.wechat.service.MessageLogService;
import com.zhoumin.wechat.service.MessageService;
import com.zhoumin.wechat.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhoumin
 * @create 2018-07-11 15:33
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageLogService messageLogService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    public String newMessageRequest(HttpServletRequest request) {
        String respMessage = null;
        MessageLog messageLog = new MessageLog();
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            LOGGER.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);
            // 消息记录写入数据库
            messageLog.setFromUserName(fromUserName);
            messageLog.setToUserName(toUserName);
            messageLog.setMsgType(msgType);
            messageLog.setContent(content);
            if (messageLogService.insertMessageLog(messageLog) < 0) {
                LOGGER.info("消息记录插入数据库成功");
            } else {
                LOGGER.error("消息记录插入数据库失败");
            }
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //这里根据关键字执行相应的逻辑，只有你想不到的，没有做不到的
//                if(content.equals("xxx")){
//
//                }
                //自动回复
                TextMessage text = new TextMessage();
                text.setContent("霍霍哈嘿" + content);
                text.setToUserName(fromUserName);
                text.setFromUserName(toUserName);
                text.setCreateTime(new Date().getTime());
                text.setMsgType(msgType);
                respMessage = MessageUtil.textMessageToXml(text);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");// 事件类型
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    //文本消息
                    TextMessage text = new TextMessage();
                    text.setContent("王雨佳是大笨蛋！");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime());
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    respMessage = MessageUtil.textMessageToXml(text);

                    //对图文消息
//                    NewsMessage newmsg=new NewsMessage();
//                    newmsg.setToUserName(fromUserName);
//                    newmsg.setFromUserName(toUserName);
//                    newmsg.setCreateTime(new Date().getTime());
//                    newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//                    newmsg.setFuncFlag(0);
//                    List<Article> articleList = new ArrayList<>();
//
//                    Article article = new Article();
//                    article.setTitle("我是一个图文");
//                    article.setDescription("我是描述信息");
//                    article.setPicUrl("https://sfault-avatar.b0.upaiyun.com/110/007/1100070317-5abcb09d42224_huge256");
//                    article.setUrl("https://segmentfault.com/u/panzi_5abcaf30a5e6b");
//                    articleList.add(article);
                    // 设置图文消息个数
//                    newmsg.setArticleCount(articleList.size());
                    // 设置图文消息包含的图文集合
//                    newmsg.setArticles(articleList);
                    // 将图文消息对象转换成xml字符串
//                    respMessage = MessageUtil.newsMessageToXml(newmsg);

                }
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅


                }
                // 自定义菜单点击事件
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//                    String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
//                    if (eventKey.equals("return_content")) {
//                        TextMessage text = new TextMessage();
//                        text.setContent("赞赞赞");
//                        text.setToUserName(fromUserName);
//                        text.setFromUserName(toUserName);
//                        text.setCreateTime(new Date().getTime());
//                        text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//                        respMessage = MessageUtil.textMessageToXml(text);
//                    }
//                }
            }
        } catch (Exception e) {
            LOGGER.error("error......");
        }
        return respMessage;
    }
}

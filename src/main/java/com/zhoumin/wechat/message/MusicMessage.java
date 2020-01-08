package com.zhoumin.wechat.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoumin
 * @create 2018-07-11 10:19
 */
@Setter
@Getter
public class MusicMessage extends BaseMessage {
    /**
     * 音乐
     */
    private Music Music;

    public com.zhoumin.wechat.message.Music getMusic() {
        return Music;
    }

    public void setMusic(com.zhoumin.wechat.message.Music music) {
        Music = music;
    }
}

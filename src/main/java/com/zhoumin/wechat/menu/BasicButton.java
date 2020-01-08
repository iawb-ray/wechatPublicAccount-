package com.zhoumin.wechat.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * 按钮基类
 * @author zhoumin
 * @create 2018-07-11 15:22
 */
@Setter
@Getter
public class BasicButton {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

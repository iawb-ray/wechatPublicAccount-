package com.zhoumin.wechat.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoumin
 * @create 2018-07-11 15:23
 */
@Setter
@Getter
public class ViewButton extends BasicButton {
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

}

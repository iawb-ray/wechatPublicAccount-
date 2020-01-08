package com.zhoumin.wechat.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * 普通按钮
 *
 * @author zhoumin
 * @create 2018-07-12 9:56
 */
@Setter
@Getter
public class CommonButton extends BasicButton {
    private String type;

    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

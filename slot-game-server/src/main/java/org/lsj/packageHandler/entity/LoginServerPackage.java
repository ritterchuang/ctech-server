package org.lsj.packageHandler.entity;

import com.fasterxml.jackson.databind.JsonNode;

// 登入服務器封包結構
public class LoginServerPackage {
    private int type;
    private JsonNode body;

    // 原始建構子提供JSON解析用
    public LoginServerPackage(){}

    public LoginServerPackage(int type, JsonNode body) {
        this.type = type;
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public JsonNode getBody() {
        return body;
    }
}

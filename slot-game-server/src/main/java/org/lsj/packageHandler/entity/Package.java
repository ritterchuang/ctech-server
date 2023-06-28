package org.lsj.packageHandler.entity;

import com.fasterxml.jackson.databind.JsonNode;

// 封包結構
public class Package {
    private int type;
    private JsonNode body;

    // 原始建構子提供JSON解析用
    public Package(){}

    public Package(int type, JsonNode body) {
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

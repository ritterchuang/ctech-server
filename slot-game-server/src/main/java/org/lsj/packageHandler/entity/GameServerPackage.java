package org.lsj.packageHandler.entity;

import com.fasterxml.jackson.databind.JsonNode;

// 遊戲服務器封包結構
public class GameServerPackage {
    private String command; // 鑑值
    private JsonNode data; // 資料

    // 原始建構子提供JSON解析用
    public GameServerPackage(){}

    public GameServerPackage(String command, JsonNode data) {
        this.command = command;
        this.data = data;
    }

    public String getCommand() {
        return command;
    }

    public JsonNode getData() {
        return data;
    }
}

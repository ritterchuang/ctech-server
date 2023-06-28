package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;

import javax.websocket.Session;

// 封包處理器介面
public interface IPackageHandler {
    // 處理
    void handle(Session session, JsonNode body);
}

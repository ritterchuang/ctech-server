package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;

import javax.websocket.Session;

// 封包處理器 握手回應
public class PackageHandler_HandShakeAck extends AbstractPackageHandler {
    public void handle(Session session, JsonNode body){
    }
}

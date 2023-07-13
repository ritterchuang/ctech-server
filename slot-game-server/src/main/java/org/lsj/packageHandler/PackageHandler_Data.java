package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.enums.RouteType;
import org.lsj.loginServer.connector.EntryHandler;
import org.lsj.loginServer.gate.GateHandler;

import javax.websocket.Session;

// 封包處理器 資訊
public class PackageHandler_Data extends AbstractPackageHandler {
    private final EntryHandler entryHandler = new EntryHandler(); // 入口處理器
    private final GateHandler gateHandler = new GateHandler(); // 網關處理器

    public void handle(Session session, JsonNode body){
        switch(RouteType.fromRoute(body.get("route").asText())){
            case CONNECTOR_ENTRYHANDLER_QUERYOSS: this.entryHandler.queryOss(session, body); break;
            case GATE_GATEHANDLER_QUERYENTRY: this.gateHandler.entry(session, body); break;
            case CONNECTOR_ENTRYHANDLER_AUTH: this.entryHandler.auth(session, body); break;
            case CONNECTOR_ENTRYHANDLER_LOGIN: this.entryHandler.login(session, body); break;
        }
    }
}

package org.lsj.loginServer.gate;

import com.fasterxml.jackson.databind.JsonNode;
import javax.websocket.Session;
import org.lsj.enums.MessageType;
import org.lsj.enums.LoginServerPackageType;
import org.lsj.enums.RouteType;
import org.lsj.loginServer.packet.PacketHandler;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

// 網關處理器
public class GateHandler {
    private final PacketHandler packetHandler = new PacketHandler(LoginServerPackageType.TYPE_DATA, MessageType.TYPE_RESPONSE); // 封包處理器

    // 入口處理
    public void entry(Session session, JsonNode body) {
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                RouteType.GATE_GATEHANDLER_QUERYENTRY,
                this.calculateQueryEntryMessageBody()))));
    }

    private JsonNode calculateQueryEntryMessageBody(){
        String messageBodyString = "{\"code\":0,\"host\":\"0.0.0.0\",\"port\":44346}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }
}

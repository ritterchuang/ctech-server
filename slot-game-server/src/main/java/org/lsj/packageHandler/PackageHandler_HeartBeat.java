package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.enums.MessageType;
import org.lsj.enums.LoginServerPackageType;
import org.lsj.loginServer.packet.PacketHandler;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 封包處理器 心跳
public class PackageHandler_HeartBeat extends AbstractPackageHandler {
    private final PacketHandler packetHandler = new PacketHandler(LoginServerPackageType.TYPE_HEARTBEAT, MessageType.TYPE_RESPONSE); // 封包處理器

    public void handle(Session session, JsonNode body){
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(
                this.packetHandler.packagePacket(JsonUtil.getInstance().getObjectMapper().createObjectNode()))
        );
    }
}

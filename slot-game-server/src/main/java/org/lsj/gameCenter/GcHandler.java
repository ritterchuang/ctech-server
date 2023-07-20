package org.lsj.gameCenter;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.enums.MessageType;
import org.lsj.enums.LoginServerPackageType;
import org.lsj.enums.RouteType;
import org.lsj.loginServer.packet.PacketHandler;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 遊戲中心處理器
public class GcHandler {
    private final PacketHandler packetHandler = new PacketHandler(LoginServerPackageType.TYPE_DATA, MessageType.TYPE_RESPONSE); // 封包處理器

    // 進入遊戲中心
    public void enterGc(Session session, JsonNode body) {
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                RouteType.GAMECENTER_GCHANDLER_ENTERGC,
                this.calculateEnterGcMessageBody()))));
    }

    private JsonNode calculateEnterGcMessageBody() {
        String messageBodyString = "{\"code\":0,\"msg\":{\"fstate\":true,\"gameid\":302,\"gameName\":\"dydb_java\",\"uid\":160759}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }
}

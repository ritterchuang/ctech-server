package org.lsj.loginServer.packet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.lsj.enums.*;
import org.lsj.utils.JsonUtil;

// 封包處理器
public class PacketHandler {
    private final PackageType packageType; // 封包類型
    private final MessageType messageType; // 訊息類型

    public PacketHandler(PackageType packageType, MessageType messageType) {
        this.packageType = packageType;
        this.messageType = messageType;
    }

    public ObjectNode packagePacket(JsonNode packetBodyJsonNode){
        // 1. 初始化節點
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 2. 計算type
        result.put("type", this.packageType.getCode());

        // 3. 計算body
        result.set("body", packetBodyJsonNode);

        return result;
    }

    // 計算封包本體
    public JsonNode calculatePacketBody(RouteType routeType, JsonNode packetBody){
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算 id: routeCode
        result.put("id", routeType.getCode());

        // 2. 計算 type
        result.put("type", this.messageType.getCode());

        // 3. 計算 compressRoute
        result.put("compressRoute", 0);

        // 4. 計算 route
        result.put("route", routeType.getNetHeadType().getNetHead());

        // 5. 計算 data
        result.set("body", packetBody);

        return result;
    }

    // 計算封包本體
    public JsonNode calculatePacketBody(FrameType frameType, JsonNode packetBody){
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算 id: frameCode
        result.put("id", frameType.getCode());

        // 2. 計算 type
        result.put("type", this.messageType.getCode());

        // 3. 計算 compressRoute
        result.put("compressRoute", 0);

        // 4. 計算 route
        result.put("route", NetHeadType.STC_FRAME_EVENTS.getNetHead());

        // 5. 計算 data
        result.set("body", packetBody);

        return result;
    }
}

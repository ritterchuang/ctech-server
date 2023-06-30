package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.lsj.enums.PackageType;
import org.lsj.enums.RouteType;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 封包處理器 握手
public class PackageHandler_HandShake extends AbstractPackageHandler {
    private final ObjectNode handShakeJsonNode; // 握手節點

    public PackageHandler_HandShake() {
        this.handShakeJsonNode = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算type
        this.handShakeJsonNode.put("type", PackageType.TYPE_HANDSHAKE.getCode());

        // 2. 計算body
        this.handShakeJsonNode.set("body", this.calculateBody());
    }

    // 計算body
    private ObjectNode calculateBody() {
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算 code
        result.put("code", 200);

        // 2. 計算 sys
        result.set("sys", this.calculateSys());

        return result;
    }

    //  計算sys
    private ObjectNode calculateSys(){
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算 heartbeat
        result.put("heartbeat", 5);

        // 2. 計算 dict
        result.set("dict", JsonUtil.getInstance().readTreeWithoutException(JsonUtil.getInstance().writeValueAsStringWithoutException(RouteType.calculateRouteToCodeMap())));

        // 3. 計算 routeToCode
        result.set("routeToCode", JsonUtil.getInstance().readTreeWithoutException(JsonUtil.getInstance().writeValueAsStringWithoutException(RouteType.calculateRouteToCodeMap())));

        // 4. 計算 codeToRoute
        result.set("codeToRoute", JsonUtil.getInstance().readTreeWithoutException(JsonUtil.getInstance().writeValueAsStringWithoutException(RouteType.calculateCodeToRouteMap())));

        // 5. 計算 dictVersion
        result.put("dictVersion", "HWxmA4bAEYORnIuf");

        // 6. 計算 useDict
        result.put("useDict", true);

        // 7. 計算 protos
        result.set("protos", this.calculateProtos());

        // 8. 計算 useProto
        result.put("useProto", true);

        // 9. 回傳結果
        return result;
    }

    // 計算 protos
    private JsonNode calculateProtos(){
        String protosString = "{\"server\":{\"onChat\":{\"msg\":{\"option\":\"required\",\"type\":\"string\",\"tag\":1},\"from\":{\"option\":\"required\",\"type\":\"string\",\"tag\":2},\"target\":{\"option\":\"required\",\"type\":\"string\",\"tag\":3},\"__messages\":{},\"__tags\":{\"1\":\"msg\",\"2\":\"from\",\"3\":\"target\"}}},\"client\":{},\"version\":\"2zWPnSlRsRxjqgcU215Uxg==\"}";
        return JsonUtil.getInstance().readTreeWithoutException(protosString);
    }

    public void handle(Session session, JsonNode body){
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.handShakeJsonNode));
    }
}

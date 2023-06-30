package org.lsj.packageHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.lsj.enums.MessageType;
import org.lsj.enums.NetHeadType;
import org.lsj.enums.PackageType;
import org.lsj.enums.RouteType;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 封包處理器 資訊
public class PackageHandler_Data extends AbstractPackageHandler {
    private final ObjectNode queryOssJsonNode; // queryOss節點
    public PackageHandler_Data() {
        this.queryOssJsonNode = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算type
        this.queryOssJsonNode.put("type", PackageType.TYPE_DATA.getCode());

        // 2. 計算body
        this.queryOssJsonNode.set("body", this.calculateBody());

    }

    // 計算body
    private ObjectNode calculateBody() {
        ObjectNode result = JsonUtil.getInstance().getObjectMapper().createObjectNode();

        // 1. 計算 id: routeCode
        result.put("id", RouteType.CONNECTOR_ENTRYHANDLER_QUERYOSS.getCode());

        // 2. 計算 type
        result.put("type", MessageType.TYPE_RESPONSE.getCode());

        // 3. 計算 compressRoute
        result.put("compressRoute", 0);

        // 4. 計算 route
        result.put("route", NetHeadType.STC_REQUIRE.getNetHead());

        // 5. 計算 data
        result.set("body", this.calculateMessageBody());

        return result;
    }

    // 計算資料節點
    private JsonNode calculateMessageBody(){
        String messageBodyString = "{\"code\":0,\"data\":{\"ossRouter\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"}],\"newGamecdn\":[],\"gamecdn\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"1.8.33\",\"appid\":\"S004\"}],\"loginimg\":[],\"router\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"},{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"}],\"routerj\":[],\"customer\":[{\"host\":\"localhost\",\"port\":44346}],\"h5site\":[],\"h5apiurl\":[],\"h5site2\":[],\"openRegister\":0,\"newPakeage\":[],\"maintain\":false,\"title\":\"\",\"IsNoLanding\":false,\"NoLandingTime\":\"\",\"maintain_H5\":false,\"title_H5\":\"\",\"IsNoLanding_H5\":false,\"NoLandingTime_H5\":\"\",\"PictureSite\":\"localhost\",\"RestrictEmulatorLogin\":true,\"base\":{\"gameid\":0,\"gps\":false,\"canshare\":false,\"update\":true,\"debugmode\":true,\"logcount\":1000},\"package\":{\"android\":{\"id\":\"\",\"version\":\"1.0.1\",\"url\":\"\"},\"ios\":{\"id\":\"\",\"version\":\"1.0.1\",\"url\":\"\"}}}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }

    public void handle(Session session, JsonNode body){
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.queryOssJsonNode));
    }
}

package org.lsj.loginServer.connector;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.enums.MessageType;
import org.lsj.enums.PackageType;
import org.lsj.enums.RouteType;
import org.lsj.gs.room.RoomHandler;
import org.lsj.loginServer.packet.PacketHandler;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 入口處理器
public class EntryHandler {
    private final PacketHandler packetHandler = new PacketHandler(PackageType.TYPE_DATA, MessageType.TYPE_RESPONSE); // 封包處理器
    private final RoomHandler roomHandler = new RoomHandler();

    // 查詢 OSS 營運支援系統 TODO token 驗證
    public void queryOss(Session session, JsonNode body){
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                RouteType.CONNECTOR_ENTRYHANDLER_QUERYOSS,
                this.calculateQueryOssMessageBody()))));
    }

    public void auth(Session session, JsonNode body){
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                RouteType.CONNECTOR_ENTRYHANDLER_AUTH,
                this.calculateAuthMessageBody()))));
    }

    public void login(Session session, JsonNode body) {
        // 1. 回傳登入封包
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                RouteType.CONNECTOR_ENTRYHANDLER_LOGIN,
                this.calculateLoginMessageBody()))));

        // 2. 回傳更新玩家資訊
        this.roomHandler.updateUser(session, body);

        // 3. 回傳更新平台資訊
        this.roomHandler.updatePlatform(session, body);
    }

    private JsonNode calculateQueryOssMessageBody(){
        String messageBodyString = "{\"code\":0,\"data\":{\"ossRouter\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"}],\"newGamecdn\":[],\"gamecdn\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"1.8.33\",\"appid\":\"S004\"}],\"loginimg\":[],\"router\":[{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"},{\"host\":\"localhost\",\"port\":44346,\"version\":\"\",\"appid\":\"\"}],\"routerj\":[],\"customer\":[{\"host\":\"localhost\",\"port\":44346}],\"h5site\":[],\"h5apiurl\":[],\"h5site2\":[],\"openRegister\":0,\"newPakeage\":[],\"maintain\":false,\"title\":\"\",\"IsNoLanding\":false,\"NoLandingTime\":\"\",\"maintain_H5\":false,\"title_H5\":\"\",\"IsNoLanding_H5\":false,\"NoLandingTime_H5\":\"\",\"PictureSite\":\"localhost\",\"RestrictEmulatorLogin\":true,\"base\":{\"gameid\":0,\"gps\":false,\"canshare\":false,\"update\":true,\"debugmode\":true,\"logcount\":1000},\"package\":{\"android\":{\"id\":\"\",\"version\":\"1.0.1\",\"url\":\"\"},\"ios\":{\"id\":\"\",\"version\":\"1.0.1\",\"url\":\"\"}}}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }

    private JsonNode calculateAuthMessageBody() {
        String messageBodyString = "{\"code\":0,\"msg\":{\"uid\":160759,\"account\":\"zq_160759\",\"pwd\":\"fd855f7279dcbd2ffc2cf696319a1c98\",\"exitUrl\":\"\",\"languageType\":\"zh_cn\"}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }

    private JsonNode calculateLoginMessageBody() {
        String messageBodyString = "{\"code\":0,\"msg\":{\"uid\":160759,\"account\":\"zq_160759\",\"nickName\":\"Boss160759\",\"ip\":\"123.204.25.100\",\"regTime\":1676284010,\"phone\":\"\",\"alipay\":\"\",\"payAccount\":\"\",\"realName\":\"\",\"robot\":0,\"baseAgencyId\":\"1100005\",\"gameid\":0,\"gsid\":\"\",\"fid\":0,\"money\":0,\"table\":0,\"chair\":-1,\"roomCode\":0,\"boxid\":0,\"role\":0,\"changeTime\":0,\"interfaceType\":1,\"playingThirdCompanyId\":0,\"companyId\":5001,\"thirdAccountId\":1101184,\"isMaintain\":false,\"isNoLanding\":false,\"isMaintain_H5\":false,\"IsNoLanding_H5\":false,\"noLandingTime\":\"\",\"NoLandingTime_H5\":\"\",\"title\":\"lx\",\"title_H5\":\"\",\"tk\":\"ff4a4611fc9461b95b481993272efacc226e86210ea04ee9f74da1cfc4122d44\",\"cutInfo\":null,\"sml\":1,\"lobbyType\":0,\"languageType\":\"zh_cn\",\"backgroundUrl\":\"\",\"cnf\":{}}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }
}

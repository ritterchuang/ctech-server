package org.lsj.gs.room;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.enums.FrameType;
import org.lsj.enums.MessageType;
import org.lsj.enums.PackageType;
import org.lsj.loginServer.packet.PacketHandler;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

public class RoomHandler {
    private final PacketHandler packetHandler = new PacketHandler(PackageType.TYPE_DATA, MessageType.TYPE_RESPONSE); // 封包處理器

    // 更新玩家
    public void updateUser(Session session, JsonNode body) {
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                FrameType.UPDATEUSER,
                this.calculateUpdateUserMessageBody1()))));
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                FrameType.UPDATEUSER,
                this.calculateUpdateUserMessageBody2()))));
    }

    // 更新平台
    public void updatePlatform(Session session, JsonNode body) {
        WebSocketUtil.getInstance().sendResponse(session, JsonUtil.getInstance().writeValueAsStringWithoutException(this.packetHandler.packagePacket(this.packetHandler.calculatePacketBody(
                FrameType.UPDATEFLATFORM,
                this.calculateUpdatePlatformMessageBody()))));
    }

    private JsonNode calculateUpdateUserMessageBody1(){
        String messageBodyString = "{\"key\":\"updateUser\",\"data\":{\"uid\":160759,\"account\":\"zq_160759\",\"thirdAccountId\":1101184,\"thirdAccount\":\"1100005_donny01\",\"nickName\":\"Boss160759\",\"headImgUrl\":\"9\",\"sex\":1,\"phone\":\"\",\"alipay\":\"\",\"payAccount\":\"\",\"realName\":\"\",\"ip\":\"123.204.25.100\",\"vipState\":1,\"vipLevel\":0,\"accountType\":0,\"wallet\":1}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }

    private JsonNode calculateUpdateUserMessageBody2() {
        String messageBodyString = "{\"key\":\"updateUser\",\"data\":{\"uid\":160759,\"diamond\":0,\"gold\":0,\"bean\":0,\"dollar\":5000}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }

    private JsonNode calculateUpdatePlatformMessageBody() {
        String messageBodyString = "{\"key\":\"updatePlatform\",\"data\":{\"vip\":false,\"promote\":true,\"gameTypes\":[{\"iconUrl1\":\"Img/2020/7/17/a5e2d03f76ea4ad38c474e2e0f90239c.png\",\"iconUrl2\":\"Img/2020/7/30/3cffd23022bb467faf58c5226440a167.png\",\"type\":1,\"lobbyTypeDebug\":0,\"en\":\"by\",\"cn\":\"捕鱼类\",\"games\":[]},{\"iconUrl1\":\"/Img/{Language}/gameCategory/dark/1080613_chessapilixin_434.png\",\"iconUrl2\":\"/Img/{Language}/gameCategory/light/1080613_chessapilixin_434.png\",\"type\":1,\"lobbyTypeDebug\":0,\"en\":\"\",\"cn\":\"電子遊藝\",\"games\":[{\"gid\":305,\"en\":\"mjws_java\",\"cn\":\"麻将无双\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":306,\"en\":\"bszx_java\",\"cn\":\"宝石之星\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":309,\"en\":\"sn_java\",\"cn\":\"水牛\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":320,\"en\":\"cjwp_java\",\"cn\":\"超级王牌\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":307,\"en\":\"ccc_java\",\"cn\":\"777\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":308,\"en\":\"sbxc_java\",\"cn\":\"三倍小丑\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":310,\"en\":\"swzs_java\",\"cn\":\"死亡之书\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":313,\"en\":\"lll_java\",\"cn\":\"龙龙龙\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":311,\"en\":\"lmjjc_java\",\"cn\":\"罗马竞技场\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":323,\"en\":\"xjtb_java\",\"cn\":\"仙境探宝\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":324,\"en\":\"zcjz_java\",\"cn\":\"招财金猪\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":304,\"en\":\"wl_java\",\"cn\":\"旺来\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":303,\"en\":\"sdzw_java\",\"cn\":\"圣诞任务\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":302,\"en\":\"dydb_java\",\"cn\":\"大运夺宝\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":301,\"en\":\"pxky_java\",\"cn\":\"貔貅开运\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":14,\"en\":\"ebg\",\"cn\":\"抢庄二八杠\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":27,\"en\":\"lznn\",\"cn\":\"癞子牛牛\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":8,\"en\":\"lhj_sx\",\"cn\":\"四象神兽\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1}]},{\"iconUrl1\":\"/Img/{Language}/gameCategory/dark/1080613_chessapilixin_435.png\",\"iconUrl2\":\"/Img/{Language}/gameCategory/light/1080613_chessapilixin_435.png\",\"type\":1,\"lobbyTypeDebug\":0,\"en\":\"\",\"cn\":\"百人遊戲\",\"games\":[{\"gid\":205,\"en\":\"szzb_java\",\"cn\":\"世足争霸\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":204,\"en\":\"rycs_java\",\"cn\":\"人鱼传说\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":203,\"en\":\"slby_java\",\"cn\":\"神龙捕鱼\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":202,\"en\":\"csby_java\",\"cn\":\"财神捕鱼\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":201,\"en\":\"jcby_java\",\"cn\":\"金蟾捕鱼\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1}]},{\"iconUrl1\":\"/Img/{Language}/gameCategory/dark/1080613_chessapilixin_436.png\",\"iconUrl2\":\"/Img/{Language}/gameCategory/light/1080613_chessapilixin_436.png\",\"type\":1,\"lobbyTypeDebug\":0,\"en\":\"\",\"cn\":\"熱門遊戲\",\"games\":[{\"gid\":126,\"en\":\"qznn_k4z_java\",\"cn\":\"新看四张抢庄牛牛\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":115,\"en\":\"qznn_ksz_java\",\"cn\":\"新看三张抢庄牛牛\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":113,\"en\":\"qznn_java\",\"cn\":\"新抢庄牛牛\",\"tag\":0,\"gameIconUrl\":\"http://18.163.28.31:8001/\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":10,\"en\":\"brnn\",\"cn\":\"百人牛牛\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":32,\"en\":\"cjnn\",\"cn\":\"超级百人牛牛\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":127,\"en\":\"lznn_java\",\"cn\":\"新癞子牛牛\",\"tag\":4,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":117,\"en\":\"sg_java\",\"cn\":\"新三公\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":25,\"en\":\"tbnn\",\"cn\":\"通比牛牛\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1}]},{\"iconUrl1\":\"/Img/{Language}/gameCategory/dark/1080613_chessapilixin_437.png\",\"iconUrl2\":\"/Img/{Language}/gameCategory/light/1080613_chessapilixin_437.png\",\"type\":1,\"lobbyTypeDebug\":0,\"en\":\"\",\"cn\":\"經典棋牌\",\"games\":[{\"gid\":9,\"en\":\"bjl\",\"cn\":\"百家乐\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":11,\"en\":\"lhd\",\"cn\":\"龙虎斗\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":114,\"en\":\"ebg_java\",\"cn\":\"新抢庄二八杠\",\"tag\":2,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":5,\"en\":\"hhdz\",\"cn\":\"红黑大战\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":22,\"en\":\"qzpj\",\"cn\":\"抢庄牌九\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":12,\"en\":\"zjh\",\"cn\":\"炸金花\",\"tag\":1,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":18,\"en\":\"hjk\",\"cn\":\"二十一点\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1},{\"gid\":29,\"en\":\"mybjl\",\"cn\":\"免佣百家乐\",\"tag\":0,\"gameIconUrl\":\"\",\"isThirdGame\":0,\"atype\":0,\"thirdGameID\":0,\"thirdChannelID\":\"\",\"gameState\":1}]}],\"vipRewardInfo\":\"{}\",\"gameOrders\":\"[[29,25,18,12,117,8,122,22,5,127,27,114,14,13,32,10,11,9,201,301,202,302,203,303,204,304,113,205,109,132,129,110,324,323,311,125,313,314,310,312,308,307,115,126,320,309,306,305,105,111]]\"}}";
        return JsonUtil.getInstance().readTreeWithoutException(messageBodyString);
    }
}

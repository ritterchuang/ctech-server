package org.lsj.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

// 路由
public enum RouteType {
    INVALID(0, "invalid", NetHeadType.INVALID), // 無效
    CONNECTOR_ENTRYHANDLER_AUTH(1, "connector.entryHandler.auth", NetHeadType.STC_REQUIRE),
    CONNECTOR_ENTRYHANDLER_BINDPHONE(2, "connector.entryHandler.bindPhone", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_ENTRY(3, "connector.entryHandler.entry", NetHeadType.STC_REQUIRE),
    CONNECTOR_ENTRYHANDLER_GETBALANCE(4, "connector.entryHandler.getBalance", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_GETPHONECODE(5, "connector.entryHandler.getPhoneCode", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_GETPHONEVERIFYCODE(6, "connector.entryHandler.getPhoneVerifyCode", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_LOGIN(7, "connector.entryHandler.login", NetHeadType.STC_REQUIRE),
    CONNECTOR_ENTRYHANDLER_MODIFYPROPERTY(8, "connector.entryHandler.modifyProperty", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_OPBANK(9, "connector.entryHandler.opBank", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_OPBANKPWD(10, "connector.entryHandler.opBankPwd", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_QUERYOSS(11, "connector.entryHandler.queryOss", NetHeadType.STC_REQUIRE),
    CONNECTOR_ENTRYHANDLER_QUERYCUT(12, "connector.entryHandler.querycut", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_REG(13, "connector.entryHandler.reg", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_REGACCOUNT(14, "connector.entryHandler.regAccount", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_REGPHONE(15, "connector.entryHandler.regPhone", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_RESETLOGINPWDBYCODE(16, "connector.entryHandler.resetLoginPwdByCode", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_ROUTEHTTP(17, "connector.entryHandler.routeHttp", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_SETLANGUAGE(18, "connector.entryHandler.setLanguage", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_SETLOBBYTYPE(19, "connector.entryHandler.setLobbyType", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_TEST(20, "connector.entryHandler.test", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_UPLOADLOCATION(21, "connector.entryHandler.uploadLocation", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_CHAT(22, "gamecenter.gcHandler.chat", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_CREATEBOX(23, "gamecenter.gcHandler.createBox", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_DISSOLVEBOX(24, "gamecenter.gcHandler.dissolveBox", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_ENTERBOX(25, "gamecenter.gcHandler.enterBox", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_ENTERFIELD(26, "gamecenter.gcHandler.enterField", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_ENTERGC(27, "gamecenter.gcHandler.enterGC", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_ENTERBYB(28, "gamecenter.gcHandler.enterbyb", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GAMEMSG(29, "gamecenter.gcHandler.gameMsg", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETBILLS(30, "gamecenter.gcHandler.getBills", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETBOXRULE(31, "gamecenter.gcHandler.getBoxRule", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETBYBBILLS(32, "gamecenter.gcHandler.getBybBills", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETFIELD(33, "gamecenter.gcHandler.getField", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETRANDOMROOMINDEX(34, "gamecenter.gcHandler.getRandomRoomIndex", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETROOMDISPLAYDATA(35, "gamecenter.gcHandler.getRoomDisplayData", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_GETUSERSTATE(36, "gamecenter.gcHandler.getUserState", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_LEAVEGC(37, "gamecenter.gcHandler.leaveGC", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_OPTABLE(38, "gamecenter.gcHandler.opTable", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_RELEASEUSERSTATE(39, "gamecenter.gcHandler.releaseUserState", NetHeadType.INVALID), // TODO
    GAMECENTER_GCHANDLER_SETUSERSTATE(40, "gamecenter.gcHandler.setUserState", NetHeadType.INVALID), // TODO
    GATE_GATEHANDLER_QUERYENTRY(41, "gate.gateHandler.queryEntry", NetHeadType.STC_REQUIRE),
    ITEM_ITEMHANDLER_QUERYALMS(42, "item.itemHandler.queryAlms", NetHeadType.INVALID), // TODO
    ITEM_ITEMHANDLER_TAKEALMS(43, "item.itemHandler.takeAlms", NetHeadType.INVALID), // TODO
    ITEM_ITEMHANDLER_TESTPROP(44, "item.itemHandler.testProp", NetHeadType.INVALID), // TODO
    ITEM_ITEMHANDLER_USEPROP(45, "item.itemHandler.useProp", NetHeadType.INVALID), // TODO
    MESSAGE_MAILHANDLER_OPERATE(46, "message.mailHandler.operate", NetHeadType.INVALID), // TODO
    CONNECTOR_ENTRYHANDLER_GETCLIENTIP(47, "connector.entryHandler.getClientIP", NetHeadType.INVALID); // TODO

    private final int code; // 編碼
    private final String route; // 路由
    private final NetHeadType netHeadType; // 網路標頭類型

    RouteType(int code, String route, NetHeadType netHeadType) {
        this.code = code;
        this.route = route;
        this.netHeadType = netHeadType;
    }

    public int getCode() {
        return code;
    }

    public String getRoute() {
        return route;
    }

    public NetHeadType getNetHeadType() {
        return netHeadType;
    }

    // 編碼查找列舉
    public static RouteType fromCode(int code) {
        final RouteType[] allEnumInstance = values();
        for (RouteType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }

    // 編碼查找列舉
    public static RouteType fromRoute(String route) {
        final RouteType[] allEnumInstance = values();
        for (RouteType enumInstance : allEnumInstance) {
            if (enumInstance.getRoute().equals(route)) {
                return enumInstance;
            }
        }
        return INVALID;
    }

    // 計算路徑對應編碼的對應表
    public static Map<String, Integer> calculateRouteToCodeMap(){
        Map<String, Integer> result = new LinkedHashMap<>();

        final RouteType[] allEnumInstance = values();
        for (RouteType enumInstance : allEnumInstance) {
            result.put(enumInstance.getRoute(), enumInstance.getCode());
        }
        return result;
    }

    // 計算編碼對應路徑的對應表
    public static Map<Integer, String> calculateCodeToRouteMap(){
        Map<Integer, String> result = new LinkedHashMap<>();

        final RouteType[] allEnumInstance = values();
        for (RouteType enumInstance : allEnumInstance) {
            result.put(enumInstance.getCode(), enumInstance.getRoute());
        }
        return result;
    }
}

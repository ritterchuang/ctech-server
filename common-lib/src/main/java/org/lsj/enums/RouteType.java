package org.lsj.enums;

import java.util.LinkedHashMap;
import java.util.Map;

// 路由
public enum RouteType {
    INVALID(0, "invalid"), // 無效
    CONNECTOR_ENTRYHANDLER_AUTH(1, "connector.entryHandler.auth"),
    CONNECTOR_ENTRYHANDLER_BINDPHONE(2, "connector.entryHandler.bindPhone"),
    CONNECTOR_ENTRYHANDLER_ENTRY(3, "connector.entryHandler.entry"),
    CONNECTOR_ENTRYHANDLER_GETBALANCE(4, "connector.entryHandler.getBalance"),
    CONNECTOR_ENTRYHANDLER_GETPHONECODE(5, "connector.entryHandler.getPhoneCode"),
    CONNECTOR_ENTRYHANDLER_GETPHONEVERIFYCODE(6, "connector.entryHandler.getPhoneVerifyCode"),
    CONNECTOR_ENTRYHANDLER_LOGIN(7, "connector.entryHandler.login"),
    CONNECTOR_ENTRYHANDLER_MODIFYPROPERTY(8, "connector.entryHandler.modifyProperty"),
    CONNECTOR_ENTRYHANDLER_OPBANK(9, "connector.entryHandler.opBank"),
    CONNECTOR_ENTRYHANDLER_OPBANKPWD(10, "connector.entryHandler.opBankPwd"),
    CONNECTOR_ENTRYHANDLER_QUERYOSS(11, "connector.entryHandler.queryOss"),
    CONNECTOR_ENTRYHANDLER_QUERYCUT(12, "connector.entryHandler.querycut"),
    CONNECTOR_ENTRYHANDLER_REG(13, "connector.entryHandler.reg"),
    CONNECTOR_ENTRYHANDLER_REGACCOUNT(14, "connector.entryHandler.regAccount"),
    CONNECTOR_ENTRYHANDLER_REGPHONE(15, "connector.entryHandler.regPhone"),
    CONNECTOR_ENTRYHANDLER_RESETLOGINPWDBYCODE(16, "connector.entryHandler.resetLoginPwdByCode"),
    CONNECTOR_ENTRYHANDLER_ROUTEHTTP(17, "connector.entryHandler.routeHttp"),
    CONNECTOR_ENTRYHANDLER_SETLANGUAGE(18, "connector.entryHandler.setLanguage"),
    CONNECTOR_ENTRYHANDLER_SETLOBBYTYPE(19, "connector.entryHandler.setLobbyType"),
    CONNECTOR_ENTRYHANDLER_TEST(20, "connector.entryHandler.test"),
    CONNECTOR_ENTRYHANDLER_UPLOADLOCATION(21, "connector.entryHandler.uploadLocation"),
    GAMECENTER_GCHANDLER_CHAT(22, "gamecenter.gcHandler.chat"),
    GAMECENTER_GCHANDLER_CREATEBOX(23, "gamecenter.gcHandler.createBox"),
    GAMECENTER_GCHANDLER_DISSOLVEBOX(24, "gamecenter.gcHandler.dissolveBox"),
    GAMECENTER_GCHANDLER_ENTERBOX(25, "gamecenter.gcHandler.enterBox"),
    GAMECENTER_GCHANDLER_ENTERFIELD(26, "gamecenter.gcHandler.enterField"),
    GAMECENTER_GCHANDLER_ENTERGC(27, "gamecenter.gcHandler.enterGC"),
    GAMECENTER_GCHANDLER_ENTERBYB(28, "gamecenter.gcHandler.enterbyb"),
    GAMECENTER_GCHANDLER_GAMEMSG(29, "gamecenter.gcHandler.gameMsg"),
    GAMECENTER_GCHANDLER_GETBILLS(30, "gamecenter.gcHandler.getBills"),
    GAMECENTER_GCHANDLER_GETBOXRULE(31, "gamecenter.gcHandler.getBoxRule"),
    GAMECENTER_GCHANDLER_GETBYBBILLS(32, "gamecenter.gcHandler.getBybBills"),
    GAMECENTER_GCHANDLER_GETFIELD(33, "gamecenter.gcHandler.getField"),
    GAMECENTER_GCHANDLER_GETRANDOMROOMINDEX(34, "gamecenter.gcHandler.getRandomRoomIndex"),
    GAMECENTER_GCHANDLER_GETROOMDISPLAYDATA(35, "gamecenter.gcHandler.getRoomDisplayData"),
    GAMECENTER_GCHANDLER_GETUSERSTATE(36, "gamecenter.gcHandler.getUserState"),
    GAMECENTER_GCHANDLER_LEAVEGC(37, "gamecenter.gcHandler.leaveGC"),
    GAMECENTER_GCHANDLER_OPTABLE(38, "gamecenter.gcHandler.opTable"),
    GAMECENTER_GCHANDLER_RELEASEUSERSTATE(39, "gamecenter.gcHandler.releaseUserState"),
    GAMECENTER_GCHANDLER_SETUSERSTATE(40, "gamecenter.gcHandler.setUserState"),
    GATE_GATEHANDLER_QUERYENTRY(41, "gate.gateHandler.queryEntry"),
    ITEM_ITEMHANDLER_QUERYALMS(42, "item.itemHandler.queryAlms"),
    ITEM_ITEMHANDLER_TAKEALMS(43, "item.itemHandler.takeAlms"),
    ITEM_ITEMHANDLER_TESTPROP(44, "item.itemHandler.testProp"),
    ITEM_ITEMHANDLER_USEPROP(45, "item.itemHandler.useProp"),
    MESSAGE_MAILHANDLER_OPERATE(46, "message.mailHandler.operate"),
    CONNECTOR_ENTRYHANDLER_GETCLIENTIP(47, "connector.entryHandler.getClientIP");

    private final int code; // 編碼
    private final String route; // 路由

    RouteType(int code, String route) {
        this.code = code;
        this.route = route;
    }

    public int getCode() {
        return code;
    }

    public String getRoute() {
        return route;
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

package org.lsj.enums;

// 網路標頭類型
public enum NetHeadType {
    INVALID(0, "invalid"), // 無效
    NET_STATUS(1, "network"), // 網路狀態標頭
    STC_REQUIRE(2, "require"), // 必須標頭
    STC_FRAME_EVENTS(3, "f_event"), // 房間事件標頭
    STC_GAME_EVENTS(4, "g_event"), // 遊戲事件標頭
    STC_CHAT_EVENTS(5, "chat_event"); // 聊天事件標頭

    private final int code; // 編碼
    private final String netHead; // 網路標頭

    NetHeadType(int code, String netHead) {
        this.code = code;
        this.netHead = netHead;
    }

    public int getCode() {
        return code;
    }

    public String getNetHead() {
        return netHead;
    }

    public static NetHeadType fromCode(int code) {
        final NetHeadType[] allEnumInstance = values();
        for (NetHeadType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

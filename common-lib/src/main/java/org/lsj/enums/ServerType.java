package org.lsj.enums;

// 服務器類型
public enum ServerType {
    INVALID(0), // 無效
    // 遊戲
    LOGIN_SERVER(1), // 登入服務器
    GAME_SERVER(2); // 遊戲服務器

    private final int code; // 編碼

    ServerType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // 編碼查找列舉
    public static ServerType fromCode(int code) {
        final ServerType[] allEnumInstance = values();
        for (ServerType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

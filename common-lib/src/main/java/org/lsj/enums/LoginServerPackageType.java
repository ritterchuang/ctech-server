package org.lsj.enums;

// 登入服務器封包類型
public enum LoginServerPackageType {
    INVALID(0), // 無效
    TYPE_HANDSHAKE(1), // 握手
    TYPE_HANDSHAKE_ACK(2), // 握手回應
    TYPE_HEARTBEAT(3), // 心跳
    TYPE_DATA(4), // 資料
    TYPE_KICK(5); // 踢出

    private final int code; // 編碼

    LoginServerPackageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static LoginServerPackageType fromCode(int code) {
        final LoginServerPackageType[] allEnumInstance = values();
        for (LoginServerPackageType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

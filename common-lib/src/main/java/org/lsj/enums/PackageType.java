package org.lsj.enums;

// 封包類型
public enum PackageType {
    INVALID(0), // 無效
    TYPE_HANDSHAKE(1), // 握手
    TYPE_HANDSHAKE_ACK(2), // 握手回應
    TYPE_HEARTBEAT(3), // 心跳
    TYPE_DATA(4), // 資料
    TYPE_KICK(5); // 踢出

    private final int code; // 編碼

    PackageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PackageType fromCode(int code) {
        final PackageType[] allEnumInstance = values();
        for (PackageType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

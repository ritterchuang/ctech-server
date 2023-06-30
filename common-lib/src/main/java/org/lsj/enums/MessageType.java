package org.lsj.enums;

 // 訊息類型
public enum MessageType {
    INVALID(-1), // 無效
     TYPE_REQUEST(0), // 請求
     TYPE_NOTIFY(1),
     TYPE_RESPONSE (2), // 回應
     TYPE_PUSH(3); // 推送

    private final int code; // 編碼

    MessageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MessageType fromCode(int code) {
        final MessageType[] allEnumInstance = values();
        for (MessageType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

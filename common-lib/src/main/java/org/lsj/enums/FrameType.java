package org.lsj.enums;

// 框架類型
public enum FrameType {
    INVALID(0, "invalid"), // 無效
    // 遊戲
    UPDATEUSER(1, "updateUser"), // 更新玩家數據
    CUTINFO(2, "cutinfo"), // 掉線信息
    HINTMSG(3, "hintmsg"), // 提示消息
    DISSOLVE(4, "dissolve"), // 遊戲解散
    ENABLEDWATERMATCH(5, "enabledWaterMatch"), // 可以開始流水匹配
    UPDATEFLATFORM(6, "updatePlatform"), // 平台開關
    NOTICECLIENT(7, "noticeClient"), // 後台通知客戶端消息
    ROOMDISPLAYDATA(8, "roomDisplayData"), // 房間列表需要展示的數據

    // 包廂
    BOXLIST(9, "boxlist"), // 玩家創建的包廂列表
    UPDATEBOX(10, "updatebox"), // 更新包廂信息

    // 遊戲設置
    GAMECONFIG(11, "gameconfig"), // 遊戲配置
    UPDATECONFIG(12, "updateconfig"), // 更新遊戲桌配置
    CONFIG(13, "config"), // 桌子的配置信息

    // 進出遊戲桌
    USERCOMEIN(14, "usercomein"), // 玩家進入桌子
    USERLIST(15, "userlist"), // 桌子上的玩家列表
    USERLEAVE(16, "userleave"), // 玩家離開桌子

    // 物品
    SHOP(17, "shop"), // 商城數據
    PROP(18, "prop"), // 玩家的道具信息
    UPDATEPROP(19, "updateProp"), // 更新玩家的道具信息
    REWARD(20, "rewards"), // 獎勵信息
    BANK(21, "bank"), // 保險箱信息
    ALMS_CFG(22, "almsCfg"), // 救濟金配置

    // 郵件
    MAIL(23, "mail"), // 玩家的郵件列表
    MAILUPDATE(24, "mailUpdate"), // 玩家郵件更新
    NEWMAIL(25, "newMail"), // 新郵件

    // 活動
    ACTIVITY(26, "activity"), // 活動
    TASK(27, "task"), // 任務
    REWARDS(28, "rewards"), // 獎勵

    // 廣播
    BROADCAST(29, "broadcast"), // 廣播消息
    REALTIME_BROADCAST(30, "realtime_broadcast"), // 實時遊戲/虛擬廣播
    ALLSYSTEM_BROADCAST(31, "allsystem_broadcast"); // 下發所有有效系統廣播


    private final int code; // 編碼
    private final String frame; // 框架

    FrameType(int code, String frame) {
        this.code = code;
        this.frame = frame;
    }

    public int getCode() {
        return code;
    }

    public String getFrame() {
        return frame;
    }

    // 編碼查找列舉
    public static FrameType fromCode(int code) {
        final FrameType[] allEnumInstance = values();
        for (FrameType enumInstance : allEnumInstance) {
            if (enumInstance.getCode() == code) {
                return enumInstance;
            }
        }
        return INVALID;
    }

    // 編碼查找列舉
    public static FrameType fromFrame(String frame) {
        final FrameType[] allEnumInstance = values();
        for (FrameType enumInstance : allEnumInstance) {
            if (enumInstance.getFrame().equals(frame)) {
                return enumInstance;
            }
        }
        return INVALID;
    }
}

package org.lsj.packageHandler;

import javax.websocket.Session;

// 封包處理器介面
public interface IPackageHandler {
    // 處理
    void handle(Session session, String body);
}

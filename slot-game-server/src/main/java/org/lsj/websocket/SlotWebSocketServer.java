package org.lsj.websocket;

import org.lsj.enums.PackageType;
import org.lsj.packageHandler.*;
import org.lsj.packageHandler.entity.Package;
import org.lsj.utils.JsonUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@ServerEndpoint(value = "/")
@ApplicationScoped
public class SlotWebSocketServer {
//    private static final Logger LOG = LoggerFactory.getLogger(SlotWebSocketServer.class);

    @OnOpen
    public void onOpen(Session session) {
//        LOG.info("{} session connected, session id: {}", LogUtil.getLogPrefix(session, 0), session.getId());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
//        LOG.info("{} session closed, session id: {}, close reason: {}, reason phrase: {}"
//                , LogUtil.getLogPrefix(session, 0)
//                , session.getId(), closeReason.getCloseCode(), closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
//        LOG.error("{} session onError, message: {}", LogUtil.getLogPrefix(session, 0), throwable.getMessage(), throwable);
    }

    @OnMessage
    public void onMessage(ByteBuffer messageBytes, Session session) {
        // 1. 打印輸入參數
        String messageString = new String(messageBytes.array(), StandardCharsets.UTF_8);
        System.out.println(Date.from(Instant.now()) + " received packageObj: " + messageString);
        // LOG.debug("{} packageObj: {}", LogUtil.getLogPrefix(session, 0), packageObj);

        // 2. 解析JSON物件
        Package packageObj = JsonUtil.getInstance().readValueWithoutException(messageString, Package.class);

        // 3. 依照類型處理
        switch(PackageType.fromCode(packageObj.getType())){
            case TYPE_HANDSHAKE: new PackageHandler_HandShake().handle(session, packageObj.getBody()); break;
            case TYPE_HANDSHAKE_ACK: new PackageHandler_HandShakeAck().handle(session, packageObj.getBody()); break;
            case TYPE_HEARTBEAT: new PackageHandler_HeartBeat().handle(session, packageObj.getBody()); break;
            case TYPE_DATA: new PackageHandler_Data().handle(session, packageObj.getBody()); break;
            case TYPE_KICK: new PackageHandler_Kick().handle(session, packageObj.getBody()); break;
            default: new PackageHandler_Default().handle(session, packageObj.getBody()); break;
        }
    }

    // 字串 轉 字節緩衝區
    private ByteBuffer stringToByteBuffer(String string){
        return ByteBuffer.wrap(string.getBytes(StandardCharsets.UTF_8));
    }
}

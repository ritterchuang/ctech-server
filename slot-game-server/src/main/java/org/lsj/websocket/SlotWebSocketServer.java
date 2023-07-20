package org.lsj.websocket;

import com.fasterxml.jackson.databind.JsonNode;
import org.lsj.commandHandler.CommandHandler;
import org.lsj.enums.Command;
import org.lsj.enums.LoginServerPackageType;
import org.lsj.enums.ServerType;
import org.lsj.packageHandler.*;
import org.lsj.packageHandler.entity.GameServerPackage;
import org.lsj.packageHandler.entity.LoginServerPackage;
import org.lsj.utils.JsonUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

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

        // 2. 讀取封包Json格式
        JsonNode packageJsonNode = JsonUtil.getInstance().readTreeWithoutException(messageString);

        // 3. 判斷請求服務器類型
        ServerType serverType = (Objects.isNull(packageJsonNode.get("command"))) ? ServerType.LOGIN_SERVER: ServerType.GAME_SERVER;

        // 4. 計算服務器請求
        switch(serverType){
            case LOGIN_SERVER: this.calculateLoginServerRequest(session, messageString); break;
            case GAME_SERVER: this.calculateGameServerRequest(session, messageString); break;
            default: break;
        }
    }

    // 計算登入服務器請求
    private void calculateLoginServerRequest(Session session, String messageString) {
        // 1. 解析JSON物件
        LoginServerPackage loginServerPackageObj = JsonUtil.getInstance().readValueWithoutException(messageString, LoginServerPackage.class);

        // 2. 依照類型處理
        switch(LoginServerPackageType.fromCode(loginServerPackageObj.getType())){
            case TYPE_HANDSHAKE: new PackageHandler_HandShake().handle(session, loginServerPackageObj.getBody()); break;
            case TYPE_HANDSHAKE_ACK: new PackageHandler_HandShakeAck().handle(session, loginServerPackageObj.getBody()); break;
            case TYPE_HEARTBEAT: new PackageHandler_HeartBeat().handle(session, loginServerPackageObj.getBody()); break;
            case TYPE_DATA: new PackageHandler_Data().handle(session, loginServerPackageObj.getBody()); break;
            case TYPE_KICK: new PackageHandler_Kick().handle(session, loginServerPackageObj.getBody()); break;
            default: System.out.println("unknown package type:" + loginServerPackageObj.getType()); break;
        }
    }

    // 計算登入服務器請求
    private void calculateGameServerRequest(Session session, String messageString) {
        // 1. 解析JSON物件
        GameServerPackage gameServerPackageObj = JsonUtil.getInstance().readValueWithoutException(messageString, GameServerPackage.class);

        // 2. 依照類型處理
        switch(Command.getCommandByCtsCommand(gameServerPackageObj.getCommand())){
            case GET_FIELD_LIST: new CommandHandler().getFieldList(session, gameServerPackageObj); break;
            case ENTER_FIELD: new CommandHandler().enterField(session, gameServerPackageObj); break;
            case KEEP_ALIVE: new CommandHandler().keepAlive(session, gameServerPackageObj); break;
            case SPIN_REQUEST: new CommandHandler().spinRequest(session, gameServerPackageObj); break;
            case UNKNOWN: System.out.println("unknown command type:" + gameServerPackageObj.getCommand()); break;
        }
    }
}

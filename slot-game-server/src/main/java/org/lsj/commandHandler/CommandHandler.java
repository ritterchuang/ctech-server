package org.lsj.commandHandler;

import org.lsj.db.CompanyFieldObjBuilder;
import org.lsj.gs.FieldConfigBuilder;
import org.lsj.gs.math.core.common.table.ISeverTableCommandSlot;
import org.lsj.gs.math.core.common.table.TableFactory;
import org.lsj.gs.math.core.common.table.entity.exception.TableException;
import org.lsj.gs.math.core.common.table.entity.message.slot.ClientSpinRequest;
import org.lsj.gs.math.core.common.table.entity.message.slot.betSpinTypeExtend.BetSpinTypeExtend;
import org.lsj.gs.math.core.slot.ConstMathSlot;
import org.lsj.gs.pool.AgencyPool;
import org.lsj.gs.pool.PersonControlConfig;
import org.lsj.gs.user.UserBdr;
import org.lsj.packageHandler.entity.GameServerPackage;
import org.lsj.utils.JsonUtil;
import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

// 遊戲服務器處理器
public class CommandHandler {
    // 牌桌工廠
    private TableFactory tableFactory = new TableFactory();

    // 虎機牌桌 TODO
    ISeverTableCommandSlot mathTable;

    // 取得房間列表
    public void getFieldList(Session session, GameServerPackage gameServerPackageObj) {
        String result = "{\"code\":0,\"command\":\"stc_fieldList\",\"data\":{\"fieldList\":[{\"fid\":302101,\"fname\":\"xinshou\",\"fnameCN\":\"初级场\",\"base\":0.01,\"min\":0.0,\"max\":0.0,\"play\":1,\"rate\":5.0,\"state\":1,\"playerNum\":0,\"gameStage\":0,\"stageLeftTime\":0,\"chart\":[],\"betTopLimit\":[]}],\"quickGames\":[15,26,202,301,126]}}";
        WebSocketUtil.getInstance().sendResponse(session, result);
    }

    // 進入房間
    public void enterField(Session session, GameServerPackage gameServerPackageObj) {
        String result = "{\"code\":0,\"command\":\"stc_fieldSetting\",\"data\":{\"balance\":4998.29,\"fieldConfig\":{\"companyId\":5001,\"master\":0,\"roomid\":0,\"gameid\":302,\"fid\":302101,\"maxPlayer\":1,\"moneyType\":4,\"roomType\":1,\"minlimit\":0.0,\"maxlimit\":0.0,\"kicklimit\":0.0,\"feeType\":0,\"fee\":5.0,\"watermatch\":true,\"gameKind\":4,\"rule\":{\"play\":1,\"base\":0.01,\"user\":1,\"round\":[],\"AA\":[]},\"fnameCN\":\"初级场\"},\"extendConfig\":{\"betTypeList\":[\"NONE\"],\"spinTypeList\":[\"NORMAL\"],\"betSpinConfigCluster\":{\"defaultBetType\":\"NONE\",\"defaultSpinType\":\"NORMAL\",\"betSpinTypeToConfigMap\":{\"NONE\":{\"NORMAL\":{\"betSpinType\":\"NONE_NORMAL\",\"betSpinConfigExtend\":{\"creditBetBoxList\":[{\"credit\":1.0,\"bet\":0.5},{\"credit\":2.0,\"bet\":1.0},{\"credit\":5.0,\"bet\":2.5},{\"credit\":10.0,\"bet\":5.0},{\"credit\":20.0,\"bet\":10.0},{\"credit\":30.0,\"bet\":15.0},{\"credit\":50.0,\"bet\":25.0},{\"credit\":100.0,\"bet\":50.0},{\"credit\":200.0,\"bet\":100.0},{\"credit\":300.0,\"bet\":150.0},{\"credit\":600.0,\"bet\":300.0},{\"credit\":1000.0,\"bet\":500.0}]}}}}},\"gameStateConfigCluster\":{\"betSpinTypeToGameStateIdMap\":{\"NONE\":{\"NORMAL\":0}},\"gameStateConfigList\":[{\"gameStateType\":\"DYDB_BASEGAME\",\"roundType\":\"NORMAL\",\"roundConfig\":{\"reelConfig\":{\"reelType\":\"REEL_DEPENDENT\",\"reelStripBoxList\":[{\"reelId\":0,\"weight\":1,\"reelConfigExtend\":{\"reelStripList\":[[2,2,2,9,10,2,2,9,10,4,7,9,1,10,7,9,1,10,7,4,9,10,1,7,9,8,4,7,10,8,5,7,9,10,3,7,9,10,1,7,9,10,4,6,9,10,3,6,8,9,5,6,7,9,3,6,10,7,5,9,10,3,7,9,4,8,10,5,7,8,10,2,9,7,10,4,6,9,10,2,7,10,9,5,9,7,4,10,7,4,9,7,2,9,10,7,2,10,7,2,7,10,8,4,9,7,4,8,7,10,4,9,7,4,10,9,4,7,10,9,4,7,10],[2,2,2,6,7,0,8,4,9,10,5,6,8,3,10,6,4,8,10,5,9,8,3,6,8,3,10,9,5,8,10,3,9,8,4,10,9,5,6,1,10,9,3,6,9,5,8,9,1,10,9,4,6,10,5,8,9,4,10,9,3,8,6,4,8,9,1,7,3,8,9,4,10,8,5,9,8,3,10,8,4,9,3,10,8,5,9,10,4,10,8,3,1,9,5,8,6,3,10,9,2,2,8,3,10,9,5,8,10,3,9,7,5,6,9,5,8,9,5,7,8,3,8,10,5,8,9,3,10,7,5,8,9,4,6,9],[6,7,8,2,2,2,6,8,2,2,6,9,10,5,8,6,7,1,8,6,7,1,8,7,3,6,8,5,10,6,4,7,10,1,4,6,8,9,0,6,7,10,1,6,9,5,8,6,4,10,6,9,5,7,8,4,6,7,3,8,9,5,7,6,3,10,6,8,5,7,6,5,8,7,3,6,8,5,7,6,4,8,7,5,6,8,3,7,6,5,8,7,4,3,6,8,5,7,6,3,8,7,5,6,8,3,7,6,5,7,6,9,3,7,9,5,10,8,3,7,9,5],[6,7,8,2,2,2,6,9,2,2,10,9,6,0,10,8,9,5,8,6,1,7,9,8,3,6,7,10,1,6,8,4,10,7,5,8,6,3,7,8,5,6,7,4,8,6,3,9,8,4,6,7,3,8,6,4,7,8,3,6,10,4,7,6,3,8,6,4,7,8,5,6,7,4,8,6,3,7,8,5,6,7,4,8,6,3,7,8,5,6,7,4,8,6,5,7,6,4],[2,2,2,6,9,2,2,8,9,10,1,6,7,3,9,6,5,7,4,6,9,5,7,10,4,7,9,3,7,10,5,7,10,1,8,9,3,1,9,5,7,3,9,7,4,10,9,3,7,8,4,10,7,3,8,10,5,8,10,4,9,10,3,9,10,5,10,9,3,9,10,5,6,9,10,3,10,9,5,10,9,3,10,9,6]]}},{\"reelId\":1,\"weight\":1,\"reelConfigExtend\":{\"reelStripList\":[[2,2,2,6,7,2,2,8,7,2,2,2,8,9,1,7,8,3,1,9,8,5,1,10,9,4,1,6,9,4,10,6,5,9,10,3,8,7,4,9,8,3,7,10,4,9,8,5,10,6,4,9,8,3,6,10,5,9,8,3,10,9,5,8,10,9],[2,2,2,6,7,2,2,6,7,3,8,6,1,7,8,5,6,9,1,8,6,5,7,8,1,9,10,4,8,7,1,9,8,3,9,10,5,8,9,4,7,8,5,10,7,3,8,10,5,7,9,3,8,10,5,9,10,3,7,8,9],[2,2,2,6,7,2,2,6,8,0,10,6,4,8,9,3,10,9,8,4,10,9,8,5,10,9,7,4,10,8,7,3,9,10,7,5,9,10,8,4,9,10,8,3,9,10,8,3,9,10,8,3,9,8,4,10,7],[2,2,2,6,7,2,2,6,8,9,4,7,9,5,6,7,4,6,7,3,6,7,4,6,7,3,6,10,4,6,7,5,10,7,3,6,10,5,6,7,10],[2,2,2,6,7,2,2,6,7,10,3,9,10,4,9,7,5,9,10,4,9,8,5,9,10,8,4,9,10,8,5,7,9,4,8,10,3,6,8,5,7,10,3,6,8,9,3,6,8,9,5,7,10,8,3,7,8,4,10,9,7,3,6,8,9]]}}]},\"initialScreenConfig\":{\"reelResult\":{\"reelId\":0,\"reelStopType\":\"STOP_BY_DEPENDENT_REEL_BOX\",\"reelStopResultExtend\":{\"reelStopBoxList\":[{\"positionId\":4,\"offset\":1.0},{\"positionId\":17,\"offset\":1.0},{\"positionId\":42,\"offset\":1.0},{\"positionId\":41,\"offset\":1.0},{\"positionId\":14,\"offset\":1.0}]}},\"initialScreenType\":\"NONE\",\"initialScreenConfigExtend\":{}}}},{\"gameStateType\":\"DYDB_FREEGAME\",\"roundType\":\"NORMAL\",\"roundConfig\":{\"reelConfig\":{\"reelType\":\"REEL_DEPENDENT\",\"reelStripBoxList\":[{\"reelId\":0,\"weight\":1,\"reelConfigExtend\":{\"reelStripList\":[[2,2,2,9,10,2,2,9,10,4,7,9,1,10,7,9,2,10,7,4,9,10,5,7,9,4,7,10,5,9,7,3,10,9,1,7,10,4,6,9,10,3,6,8,9,5,7,9,4,6,10,5,9,10,3,7,9,4,8,10,5,7,8,2,6,7,4,6,7,2,8,7,2,2,8,10,4,9,6,3,8,7,4,10,7,4,8,10],[2,2,2,6,7,8,4,9,10,5,6,8,3,10,6,4,8,10,5,9,8,3,6,8,3,10,9,5,8,10,3,9,8,4,10,9,5,6,1,10,9,3,6,9,4,10,6,1,9,10,4,6,9,3,10,7,4,9,10,3,8,10,4,8,6,3,8,9,0,4,10,8,5,9,2,2,8,3,10,8,4,9,3,10,0,8,3,9,10,4,10,5,7,2,2,2,8,9,5,8,6,3,10,9,2,2,8,3,10,9,5,8,10,3,9,7,5,0,6,9,3,8,10,5,7,8],[6,7,8,2,2,2,6,8,2,2,6,9,2,2,2,8,10,5,6,7,1,8,6,7,1,8,7,3,6,8,5,10,2,7,2,4,10,8,4,7,9,2,2,9,5,6,0,8,4,9,7,0,5,7,8,4,9,7,3,8,9,5,7,6,3,9,8,5,10,8,5,7,6,3,10,8,5,7,6,4,8,7,5,6,8,3,7,6,5,8,7,4,3,6,8,5,7,6,3,8,7,5,6,8,3,7,6,5,7,6,9,3,7,9,5,10,8,3,0,7,9,5],[6,7,8,2,2,2,6,9,2,2,10,9,2,2,2,8,9,5,8,6,1,7,9,3,8,6,0,7,10,1,6,8,4,10,7,5,8,6,3,7,4,9,8,5,6,7,4,8,6,3,9,8,4,6,7,3,9,6,4,7,9,3,6,10,4,7,6,3,8,6,4,7,0,8,5,9,7,4,8,6,3,7,8,5,6,7,4,9,5,3,7,9,2,2,6,0,9,7,4,9,6,2,2,2],[2,2,2,9,6,2,2,8,7,10,2,2,6,7,3,9,6,5,7,4,6,9,5,7,6,4,7,9,3,7,10,5,7,10,1,8,9,3,1,9,5,7,10,3,9,7,4,10,9,3,7,8,4,10,6,3,8,10,5,7,8,10,4,9,8,3,9,10,2,7,6,9,3,7,9,10,2,7,8,3,10,9,2,7,8,3,10,9]]}},{\"reelId\":1,\"weight\":1,\"reelConfigExtend\":{\"reelStripList\":[[2,2,2,9,10,2,2,9,10,4,7,9,1,10,7,9,2,10,7,4,9,10,5,7,9,4,7,10,5,9,7,3,10,9,1,7,10,4,6,9,10,3,6,8,9,5,7,9,4,6,10,5,9,10,3,7,9,4,8,10,5,7,8,2,6,7,4,6,7,2,8,7,2,2,8,10,4,9,6,3,8,7,4,10,7,4,8,10],[2,2,2,6,7,8,4,9,10,5,6,8,3,10,6,4,8,10,5,9,8,3,6,8,3,10,9,5,8,10,3,9,8,4,10,9,5,6,1,10,9,3,6,9,4,10,6,1,9,10,4,6,9,3,10,7,4,9,10,3,8,10,4,8,6,3,8,9,0,4,10,8,5,9,2,2,8,3,10,8,4,9,3,10,0,8,3,9,10,4,10,5,7,2,2,2,8,9,5,8,6,3,10,9,2,2,8,3,10,9,5,8,10,3,9,7,5,0,6,9,3,8,10,5,7,8],[6,7,8,2,2,2,6,8,2,2,6,9,2,2,2,8,10,5,6,7,1,8,6,7,1,8,7,3,6,8,5,10,2,7,2,4,10,8,4,7,9,2,2,9,5,6,0,8,4,9,7,0,5,7,8,4,9,7,3,8,9,5,7,6,3,9,8,5,10,8,5,7,6,3,10,8,5,7,6,4,8,7,5,6,8,3,7,6,5,8,7,4,3,6,8,5,7,6,3,8,7,5,6,8,3,7,6,5,7,6,9,3,7,9,5,10,8,3,0,7,9,5],[6,7,8,2,2,2,6,9,2,2,10,9,2,2,2,8,9,5,8,6,1,7,9,3,8,6,0,7,10,1,6,8,4,10,7,5,8,6,3,7,4,9,8,5,6,7,4,8,6,3,9,8,4,6,7,3,9,6,4,7,9,3,6,10,4,7,6,3,8,6,4,7,0,8,5,9,7,4,8,6,3,7,8,5,6,7,4,9,5,3,7,9,2,2,6,0,9,7,4,9,6,2,2,2],[2,2,2,9,6,2,2,8,7,10,2,2,6,7,3,9,6,5,7,4,6,9,5,7,6,4,7,9,3,7,10,5,7,10,1,8,9,3,1,9,5,7,10,3,9,7,4,10,9,3,7,8,4,10,6,3,8,10,5,7,8,10,4,9,8,3,9,10,2,7,6,9,3,7,9,10,2,7,8,3,10,9,2,7,8,3,10,9]]}}]},\"initialScreenConfig\":{\"reelResult\":{\"reelId\":0,\"reelStopType\":\"STOP_BY_DEPENDENT_REEL_BOX\",\"reelStopResultExtend\":{\"reelStopBoxList\":[{\"positionId\":4,\"offset\":1.0},{\"positionId\":28,\"offset\":1.0},{\"positionId\":28,\"offset\":1.0},{\"positionId\":30,\"offset\":1.0},{\"positionId\":47,\"offset\":1.0}]}},\"initialScreenType\":\"NONE\",\"initialScreenConfigExtend\":{}}}}]}}}}";
        WebSocketUtil.getInstance().sendResponse(session, result);
    }

    // 保持存活
    public void keepAlive(Session session, GameServerPackage gameServerPackageObj) {
        String result = "{\"code\":0,\"command\":\"stc_keepAlive\",\"data\":{}}";
        WebSocketUtil.getInstance().sendResponse(session, result);
    }

    // 老虎機旋轉請求
    public void spinRequest(Session session, GameServerPackage gameServerPackageObj) {
        // 1. 建立牌桌 TODO 資訊
        try {
            if(Objects.isNull(this.mathTable)) {
                this.mathTable = tableFactory.createISeverTableCommandSlot(
                        new AtomicInteger(1),
                        new FieldConfigBuilder()
                                .setGameId(302)
                                .setMinUser((short) 1)
                                .setMaxUser((short) 1)
                                .setFieldConfigMap(new HashMap<>() {{
                                    put(302101, new CompanyFieldObjBuilder()
                                            .setGameId(302)
                                            .setLimitMin(0)
                                            .setLimitKick(0)
                                            .setBase(1)
                                            .createCompanyFieldObj());
                                }}).createFieldConfig(),
                        302101,
                        new AgencyPool(),
                        new PersonControlConfig(null, null),
                        new UserBdr()
                                .setBalance(10000)
                                .setSession(session)
                                .createUser());
            }else{
                this.mathTable.updateUser(
                        new UserBdr()
                                .setBalance(10000)
                                .setSession(session)
                                .createUser()
                );
            }
        } catch (TableException e) {
            e.printStackTrace();
        }

        // 2. 取得結果 TODO 與客端協議 仍在設計中
        try {
            this.mathTable.getSpinResult(JsonUtil.getInstance().writeValueAsStringWithoutException(
                    new ClientSpinRequest(1, ConstMathSlot.BetType.NONE, ConstMathSlot.SpinType.NORMAL, ConstMathSlot.BetSpinType.NONE_NORMAL,new BetSpinTypeExtend())
            ));

            this.mathTable.sendSpinResultToHumanPlayer();
        } catch (TableException e) {
            e.printStackTrace();
        } catch (Exception e) {
//            LOG.error("{} send message error, message: {}, exMessage: {}", LogUtil.getLogPrefix(session, 0), e.getMessage(), new String(messageByteBuffer.array(), StandardCharsets.UTF_8), e);
            e.printStackTrace();
        }
    }
}

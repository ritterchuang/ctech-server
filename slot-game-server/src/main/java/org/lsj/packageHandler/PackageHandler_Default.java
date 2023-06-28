package org.lsj.packageHandler;

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
import org.lsj.utils.JsonUtil;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

// 封包處理器 預設
public class PackageHandler_Default extends AbstractPackageHandler {
    // 牌桌工廠
    private TableFactory tableFactory = new TableFactory();

    // 虎機牌桌 TODO
    ISeverTableCommandSlot mathTable;

    public void handle(Session session, String body){
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

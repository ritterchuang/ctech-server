package org.lsj.gs.math.config.module.tableGameConfigGtr.games;

import org.lsj.gs.math.config.entity.tableGameConfig.ConstTableGameConfig;
import org.lsj.gs.math.config.entity.tableGameConfig.TableGameConfigLhdJava;
import org.lsj.gs.math.config.module.TableGameConfigReader;
import org.lsj.gs.math.config.module.tableGameConfigGtr.AbstractTableGameConfigGtrBaiRen;
import org.lsj.gs.user.IUser;

// 新龍虎鬥 牌桌遊戲設定產生器
public class TableGameConfigGtrLhdJava extends AbstractTableGameConfigGtrBaiRen {
    public TableGameConfigLhdJava generateTableGameConfig(IUser user) {
        return (TableGameConfigLhdJava)TableGameConfigReader.getInstance().getTableGameConfig(
                ConstTableGameConfig.TableGameConfigResource.LHD_JAVA_DEFAULT);
    }
}

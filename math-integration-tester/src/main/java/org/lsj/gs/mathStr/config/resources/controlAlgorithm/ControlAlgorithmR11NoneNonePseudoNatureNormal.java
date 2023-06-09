package org.lsj.gs.mathStr.config.resources.controlAlgorithm;

import org.lsj.gs.math.core.common.ConstMathCommon;
import org.lsj.gs.math.core.common.table.module.tableUtil.controlAlgorithm.ControlAlgorithmUtil;
import org.lsj.gs.mathStr.config.entity.ControlAlgorithmConfig;

// 強控演算法設定 不控水池 不控開牌 偽自然發牌 個人控自然
public class ControlAlgorithmR11NoneNonePseudoNatureNormal {
    public ControlAlgorithmConfig create(){
        return new ControlAlgorithmConfig(
            new ControlAlgorithmUtil(
                    true,
                    ConstMathCommon.PoolControlType.NONE,
                    ConstMathCommon.DealType.NONE,
                    ConstMathCommon.ShuffleType.PSEUDO_NATURE,
                    ConstMathCommon.PersonAdjustType.NORMAL
            )
        );
    }
}
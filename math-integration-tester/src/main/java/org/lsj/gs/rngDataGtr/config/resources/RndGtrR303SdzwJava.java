package org.lsj.gs.rngDataGtr.config.resources;

import org.lsj.gs.math.core.slot.ConstMathSlot;
import org.lsj.gs.mathBoardGtr.config.entity.ConstBoardGtr;
import org.lsj.gs.mathBoardGtr.config.entity.playGameField.ConstPlayGameField;
import org.lsj.gs.mathBoardGtr.config.module.BoardGtrConfigFactory;
import org.lsj.gs.rngDataGtr.config.entity.RngDataGtrConfig;
import org.lsj.gs.rngDataGtr.config.entity.RngDataScenarioHlrConfig;
import org.lsj.gs.rngDataGtr.config.entity.rngDataTester.RngDataTesterConfig;
import org.lsj.gs.rngDataGtr.config.entity.rngDataTester.testCase.TestCaseConfig;
import org.lsj.gs.rngDataGtr.config.entity.rngDataTester.testCase.TestCaseConfigESlotOddsWinType;
import org.lsj.gs.rngDataGtr.core.entity.ConstRngDataGtr;

import java.util.ArrayList;

// 亂數產生器設定 303 聖誕任務
public class RndGtrR303SdzwJava extends AbstractRndGtrR {
    public RngDataGtrConfig create(){
        return new RngDataGtrConfig(
                new RngDataScenarioHlrConfig(1000000),
                new BoardGtrConfigFactory().create(ConstPlayGameField.PlayGameFieldResource.R303_SDZW_JAVA_NORMAL, ConstBoardGtr.BoardGtrControlAlgorithmType.NATURE),
                new RngDataTesterConfig(
                        new ArrayList<>(){{
                            add(new TestCaseConfig(ConstRngDataGtr.TestCaseTypeEnum.E_SLOT_ODDS_WIN_TYPE, new TestCaseConfigESlotOddsWinType(ConstMathSlot.OddsWinType.NO_WIN)));
                            add(new TestCaseConfig(ConstRngDataGtr.TestCaseTypeEnum.E_SLOT_ODDS_WIN_TYPE, new TestCaseConfigESlotOddsWinType(ConstMathSlot.OddsWinType.REGULAR_WIN)));
                            add(new TestCaseConfig(ConstRngDataGtr.TestCaseTypeEnum.E_SLOT_ODDS_WIN_TYPE, new TestCaseConfigESlotOddsWinType(ConstMathSlot.OddsWinType.BIG_WIN)));
                            add(new TestCaseConfig(ConstRngDataGtr.TestCaseTypeEnum.E_SLOT_ODDS_WIN_TYPE, new TestCaseConfigESlotOddsWinType(ConstMathSlot.OddsWinType.MEGA_WIN)));
                            add(new TestCaseConfig(ConstRngDataGtr.TestCaseTypeEnum.E_SLOT_ODDS_WIN_TYPE, new TestCaseConfigESlotOddsWinType(ConstMathSlot.OddsWinType.ULTRA_WIN)));
                        }}
                )
        );
    }
}
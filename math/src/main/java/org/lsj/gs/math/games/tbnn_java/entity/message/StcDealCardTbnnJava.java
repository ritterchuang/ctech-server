package org.lsj.gs.math.games.tbnn_java.entity.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.lsj.utils.JsonUtil;

// 發牌訊息
public class StcDealCardTbnnJava extends AbstractStcMessageTbnnJava {
    @JsonIgnore public int[] cards; // 卡牌編碼

    public StcDealCardTbnnJava(int[] cards){
        super(StcDealCardTbnnJava.class.getCanonicalName());
        this.cards = cards;
        ((ObjectNode)super.data).putArray("cards").addAll((ArrayNode) JsonUtil.getInstance().getObjectMapper().valueToTree(cards));
    }
}

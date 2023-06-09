package org.lsj.gs.math.games.zjh_java.entity.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ObjectNode;

// 玩家搶莊訊息
public class StcVieBankerZjhJava extends AbstractStcMessageZjhJava {
    @JsonIgnore public int chair; // 座位
    @JsonIgnore public int rate; // 搶莊倍數

    public StcVieBankerZjhJava(int chair, int rate) {
        super(StcVieBankerZjhJava.class.getCanonicalName());
        this.chair = chair;
        this.rate = rate;
        ((ObjectNode)super.data).put("chair", chair);
        ((ObjectNode)super.data).put("rate", rate);
    }
}
package org.lsj.packageHandler;

import org.lsj.websocket.WebSocketUtil;

import javax.websocket.Session;

// 封包處理器 握手
public class PackageHandler_HandShake extends AbstractPackageHandler {
    private String handShakeString = "{'type':1,'body':{'code':200,'sys':{'heartbeat':5,'dict':{'connector.entryHandler.entry':1,'connector.entryHandler.getClientIP':2,'connector.entryHandler.queryOss':3},'routeToCode':{'connector.entryHandler.entry':1,'connector.entryHandler.getClientIP':2,'connector.entryHandler.queryOss':3},'codeToRoute':{'1':'connector.entryHandler.entry','2':'connector.entryHandler.getClientIP','3':'connector.entryHandler.queryOss'},'dictVersion':'PI+HWxmA4bAEYORnIuf+nw==','useDict':true,'protos':{'server':{'onChat':{'msg':{'option':'required','type':'string','tag':1},'from':{'option':'required','type':'string','tag':2},'target':{'option':'required','type':'string','tag':3},'__messages':{},'__tags':{'1':'msg','2':'from','3':'target'}}},'client':{},'version':'2zWPnSlRsRxjqgcU215Uxg=='},'useProto':true}}}";

    public void handle(Session session, String body){
        WebSocketUtil.getInstance().sendResponse(session, this.handShakeString);
    }
}

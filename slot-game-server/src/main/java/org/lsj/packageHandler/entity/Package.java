package org.lsj.packageHandler.entity;

// 封包結構
public class Package {
    private int type;
    private String body;

    public Package(int type, String body) {
        this.type = type;
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public String getBody() {
        return body;
    }
}

package com.example.shifu.mikroteching.ChatBot;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 10/06/2018.
 */

class ChatMessage {
    private String msgText;
    private String msgUser;


    public ChatMessage(String msgText, String msgUser) {
        this.msgText = msgText;
        this.msgUser = msgUser;

    }


    public ChatMessage() {

    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(String msgUser) {
        this.msgUser = msgUser;
    }
}

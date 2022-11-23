package com.tingtu.ax.admin.message;

/**
 * @author Administrator
 */
public interface BootAdminMsg {
    /**
     * 发送消息
     *
     * @param receiver 消息接收人
     * @param title    消息标题
     * @param content  消息内容
     */
    void sendMsg(String receiver, String title, String content);
}

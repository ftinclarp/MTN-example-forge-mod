package com.mtn.example;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

/**
 * R3a network smoke-test message. Only REGISTERED, not sent yet — it is
 * exercised for real in R3b when the chest GUI drives the network.
 */
public class MyTestMessage implements IMessage {

    private String text = "";

    public MyTestMessage() {
    }

    public MyTestMessage(String text) {
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }

    public String getText() {
        return text;
    }
}

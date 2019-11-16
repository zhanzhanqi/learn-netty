package com.zlp.learnnetty.encoder_decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        MessagePack messagePack = new MessagePack();

        final byte[] array;
        final int len = msg.readableBytes();
        array = new byte[len];
        msg.getBytes(msg.readerIndex(), array, 0, len);
        out.add(messagePack.read(array));

    }
}

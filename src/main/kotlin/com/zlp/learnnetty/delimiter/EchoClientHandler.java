package com.zlp.learnnetty.delimiter;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;

public class EchoClientHandler extends SimpleChannelInboundHandler<String>{

    private int counter;
    private static final String ECHO_REQ = "Hi, Lilingfen. Welcome to Netty.$_";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("This is " + ++counter + " times receive server: [" + msg + "]");
    }

}

package com.example.cn.demoapplication.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月22日 09:25
 * @description: 服务器处理器
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 接收到来自客户端的消息并打印
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] reg = new byte[buf.readableBytes()];

        buf.readBytes(reg);
        String body = new String( reg, "UTF-8");
        System.out.println(Thread.currentThread().getName() + ", The server receive  order: " + body);

        String replyMsg = "I am server, success";
        ByteBuf respBuf = Unpooled.copiedBuffer(replyMsg.getBytes());
        ctx.write(respBuf);
    }

    /**
     * 接收消息完成后刷新
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}

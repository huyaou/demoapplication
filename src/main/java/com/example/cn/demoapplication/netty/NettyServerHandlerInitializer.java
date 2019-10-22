package com.example.cn.demoapplication.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 17:12
 * @description:
 */
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {

    /**
     * 添加处理器
     * @param channel
     */
    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline().addLast(new NettyServerHandler());
    }
}

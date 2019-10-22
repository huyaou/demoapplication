package com.example.cn.demoapplication.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 17:18
 * @description:
 */
public class ClientHandlerInitializer extends ChannelInitializer<Channel> {
    /**
     * 初始化添加handler
     * @param channel
     */
    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline().addLast(new NettyClientHandler());
    }
}

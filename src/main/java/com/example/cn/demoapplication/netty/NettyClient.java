package com.example.cn.demoapplication.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 17:00
 * @description: netty客户端
 */
@Component
@Slf4j
public class NettyClient {
    private EventLoopGroup group = new NioEventLoopGroup();

    static final Integer SIZE = 256;

    @Value("${netty.port}")
    private Integer port;

    @Value("${netty.host}")
    private String host;

    /**
     * 初始化客户端
     */
    @PostConstruct
    @ConditionalOnBean(name = "netty")
    public void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ClientHandlerInitializer());

        ChannelFuture future = bootstrap.connect(host, port).sync();
        future.channel().closeFuture().sync();
    }

    @PreDestroy
    public void destroy() {
        group.shutdownGracefully();
    }
}

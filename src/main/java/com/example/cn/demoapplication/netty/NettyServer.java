package com.example.cn.demoapplication.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 16:48
 * @description: netty服务端
 */
@Component
@Slf4j
public class NettyServer {
    private EventLoopGroup boss = new NioEventLoopGroup();

    private EventLoopGroup work = new NioEventLoopGroup();

    @Value("${netty.port}")
    private Integer port;

    /**
     * 初始化服务端
     * @throws InterruptedException
     */
    //@PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new NettyServerHandlerInitializer());
        //bootstrap.bind(port).sync();
        ChannelFuture future =bootstrap.bind().sync();
        future.channel().closeFuture().sync();
    }

    /**
     * 优雅退出对象，释放线程池资源
     * @throws InterruptedException
     */
    @PreDestroy
    public void destory() throws InterruptedException {
        boss.shutdownGracefully().sync();
        work.shutdownGracefully().sync();
        log.info("关闭 Netty...");
    }
}

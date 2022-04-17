package XD.XDDOS.methods;

import XD.XDDOS.ProxyLoader;
import io.netty.channel.Channel;
import java.util.function.BiConsumer;

public interface Method extends BiConsumer<Channel, ProxyLoader.Proxy> {}

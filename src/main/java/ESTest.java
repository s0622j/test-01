import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class ESTest {
    // 配置你的es,如果你的集群名称不是默认的elasticsearch，需要以下这步
    Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
    TransportClient client = new PreBuiltTransportClient(settings);

}

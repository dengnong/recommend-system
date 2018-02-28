package test.com.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by 54472 on 2018/2/26.
 */
public class connect {

    private static String host = "192.168.88.132";
    private static int port = 9300;
    private TransportClient client = null;
//    @Before
//    public void getConnect() throws UnknownHostException {
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.88.132"), 9200));
//        System.out.println("Elasticsearch connect info:" + client.toString());
//        client.close();
//    }
//
//    @After
//    public void closeConnect() {
//        if(null != client) {
//            client.close();
//        }
//    }

    @Test
    public void addIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
                .startObject().field("userName", "张三")
                .field("sendDate", new Date())
                .field("msg", "你好李四")
                .endObject()).get();

        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }

    /**
     * 添加索引:传入json字符串
     * @Title: addIndex2
     * @author sunt
     * @date 2017年11月23日
     * @return void
     */
    @Test
    public void addIndex2() {
        String jsonStr = "{" +
                "\"userName\":\"张三\"," +
                "\"sendDate\":\"2017-11-30\"," +
                "\"msg\":\"你好李四\"" +
                "}";
        IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr, XContentType.JSON).get();
        System.out.println("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());

    }

    @Test
    public void getData() {
        GetResponse getResponse = client.prepareGet("test-1", "form", "1040211").get();
        System.out.println("索引库的数据:" + getResponse.getSourceAsString());
    }
}

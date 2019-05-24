import com.mongodb.MongoClient;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

/**
 * @Project: mongodboperate
 * @Package: PACKAGE_NAME
 * @Author: 冯前进
 * @Date: 2018-08-30 15:14
 * @Description: TODO
 **/
public class MongoHelper1 {

    static final String DBName = "tttt";
    static final String ServerAddress2 = "ip";
    static final int PORT = 27017;

    public MongoHelper1() {
    }

    public MongoClient getMongoClient() {
        MongoClient mongoClient = null;
        try {
            // 连接到 mongodb 服务
            mongoClient = new MongoClient(ServerAddress2, PORT);
            System.out.println("Connect to mongodb successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mongoClient;
    }
    public MongoClient getMongoClient2() {
        MongoClient mongoClient = null;
        try {
            ServerAddress serverAddress = new ServerAddress("10.2.2.59",27017);
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("gktj2019", "gktj", "HNGXhngx!@#$".toCharArray());
            // 连接到 mongodb 服务
            mongoClient = new MongoClient(Arrays.asList(serverAddress), Arrays.asList(credential));
            System.out.println("Connect to mongodb successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mongoClient;
    }

    public MongoDatabase getMongoDataBase(MongoClient mongoClient) {
        MongoDatabase mongoDataBase = null;
        try {
            if (mongoClient != null) {
                // 连接到数据库
                mongoDataBase = mongoClient.getDatabase(DBName);
                System.out.println("Connect to DataBase successfully");
            } else {
                throw new RuntimeException("MongoClient不能够为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDataBase;
    }

    public void closeMongoClient(MongoDatabase mongoDataBase, MongoClient mongoClient) {
        if (mongoDataBase != null) {
            mongoDataBase = null;
        }
        if (mongoClient != null) {
            mongoClient.close();
        }
        System.out.println("CloseMongoClient successfully");

    }
}

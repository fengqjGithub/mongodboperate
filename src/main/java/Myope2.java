import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

/**
 * @Project: mongodboperate
 * @Package: PACKAGE_NAME
 * @Author: 冯前进
 * @Date: 2018-08-30 15:22
 * @Description: TODO
 **/
public class Myope2 {
    public static void main(String[] args) {
        String dbName = "tttt";
        MongoHelper1 mongoHelper = new MongoHelper1();
        MongoClient mongoClient = mongoHelper.getMongoClient();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
        MongoCollection<Document> list= mongoDataBase.getCollection("log");
        BasicDBObject basicDBObject=new BasicDBObject();
        basicDBObject.put("phoneType","web");
        basicDBObject.put("methodName","restfulLogin");
        MongoCursor<Document> cursor =list.find(basicDBObject).iterator();
        System.out.println("数据已经取完，开始遍历------");
        Set<String> set =new HashSet<String>();
        while (cursor.hasNext()){
            JSONObject jsonObject = JSONObject.parseObject(cursor.next().toJson().toString());
            String userName=  jsonObject.getString("userName");
            set.add(userName);
        }
        for(String a:set){
            System.out.println(a);
        }
        System.out.println("===");

    }
}

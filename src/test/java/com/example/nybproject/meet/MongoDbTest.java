package com.example.nybproject.meet;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author ZhaoDesong
 * @date 2020/11/2 16:45
 */
@SpringBootTest
public class MongoDbTest {
    @Resource
    private GridFsTemplate gridFsTemplate;

    @Test
    void test() throws FileNotFoundException {
        File file = new File("D:\\创建数据包测试.txt");
        String fileName = file.getName();
        InputStream inputStream = new FileInputStream(file);
        // 可选参数，即文件类型，如txt
        String contentType = file.getName().substring(fileName.lastIndexOf(".") + 1, fileName.length());
        ObjectId objectId = gridFsTemplate.store(inputStream, fileName);
        System.out.println(objectId);

        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(objectId)));

        System.out.println(gridFSFile.getFilename());
    }
}

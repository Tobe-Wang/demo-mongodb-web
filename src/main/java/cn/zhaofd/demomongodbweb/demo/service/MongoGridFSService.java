package cn.zhaofd.demomongodbweb.demo.service;

import cn.zhaofd.demomongodbweb.demo.repository.MongoGridFSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 继承core-spring-mongodb的应用示例
 */
@Service
public class MongoGridFSService {
    private final MongoGridFSRepository mongoGridFSRepository;

    /**
     * 构造函数
     *
     * @param mongoGridFSRepository mongoGridFSRepository
     */
    public MongoGridFSService(@Autowired MongoGridFSRepository mongoGridFSRepository) {
        this.mongoGridFSRepository = mongoGridFSRepository;
    }

    /**
     * 保存文件
     *
     * @param multipartFile 文件
     * @return 文件id
     */
    public String store(MultipartFile multipartFile) {
        return mongoGridFSRepository.store(multipartFile);
    }


    /**
     * 获取文件
     *
     * @param fileId 文件id
     * @return GridFsResource
     */
    public GridFsResource getResource(String fileId) {
        return mongoGridFSRepository.getResource(fileId);
    }

    /**
     * 删除文件
     *
     * @param fileId 文件id
     */
    public void delete(String fileId) {
        mongoGridFSRepository.delete(fileId);
    }
}

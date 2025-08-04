package cn.zhaofd.demomongodbweb.demo.web;

import cn.zhaofd.core.spring.mongodb.RestGridFsUtil;
import cn.zhaofd.demomongodbweb.demo.service.MongoGridFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * 继承core-spring-mongodb的应用示例
 */
@RestController
@RequestMapping("/mongo/gridfs")
public class MongoGridFSController {
    private final MongoGridFSService mongoGridFSService;

    /**
     * 构造函数
     *
     * @param mongoGridFSService mongoGridFSService
     */
    @Autowired
    public MongoGridFSController(MongoGridFSService mongoGridFSService) {
        this.mongoGridFSService = mongoGridFSService;
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 状态码
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String upload(@RequestParam MultipartFile file) {
        return mongoGridFSService.store(file);
    }

    /**
     * 流式下载文件
     *
     * @param fileId           文件id
     * @param downloadFileName 下载显示的文件名
     * @return 流式响应实体
     */
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> download(@RequestParam String fileId, @RequestParam(required = false) String downloadFileName) {
        GridFsResource getResource = mongoGridFSService.getResource(fileId);
        return RestGridFsUtil.streamDownload(getResource, downloadFileName);
    }

    /**
     * 删除文件
     *
     * @param fileId 主文件id
     */
    @DeleteMapping(value = "/{fileId}")
    public void deleteByFileId(@PathVariable String fileId) {
        mongoGridFSService.delete(fileId);
    }
}

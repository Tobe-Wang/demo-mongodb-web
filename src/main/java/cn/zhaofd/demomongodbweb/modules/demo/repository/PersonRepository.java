package cn.zhaofd.demomongodbweb.modules.demo.repository;

import cn.zhaofd.demomongodbweb.modules.demo.dto.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 存储常规集合示例
 */
public interface PersonRepository extends MongoRepository<Person, String> {
	List<Person> findByName(String name);
	
	@Query("{'age': ?0}")
	List<Person> withQueryFindByAge(Integer age);
}

package cn.zhaofd.demomongodbweb.modules.demo.web;

import cn.zhaofd.demomongodbweb.modules.demo.dto.Location;
import cn.zhaofd.demomongodbweb.modules.demo.dto.Person;
import cn.zhaofd.demomongodbweb.modules.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 存储常规集合示例
 */
@RestController
@RequestMapping("/demo/person")
public class PersonController {
	private final PersonService personService;

	public PersonController(@Autowired PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/save")
	public Person save(){
		Person p = new Person("wyf",34);
		Collection<Location> locations = new LinkedHashSet<Location>();
		Location loc1 = new Location("上海","2009");
		Location loc2 = new Location("合肥","2010");
		Location loc3 = new Location("广州","2011");
		Location loc4 = new Location("马鞍山","2012");
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
		locations.add(loc4);
		p.setLocations(locations);
		
		return personService.save(p);
	}
	
	@RequestMapping("/findByName")
	public List<Person> findByName(String name){
		return personService.findByName(name);
	}
	
	@RequestMapping("/withQueryFindByAge")
	public List<Person> withQueryFindByAge(Integer age){
		return personService.withQueryFindByAge(age);
	}
}

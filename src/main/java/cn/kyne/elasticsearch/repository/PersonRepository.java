package cn.kyne.elasticsearch.repository;

import cn.kyne.elasticsearch.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by zhangkun01 on 2017/8/22.
 */
public interface PersonRepository extends ElasticsearchRepository<Person,Integer> {

}

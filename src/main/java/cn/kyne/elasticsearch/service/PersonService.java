package cn.kyne.elasticsearch.service;

import cn.kyne.elasticsearch.model.Person;

import java.util.List;

/**
 * Created by zhangkun01 on 2017/8/22.
 */
public interface PersonService {
    /**
     * Created By zhangkun01 on 16:14 2017/8/22.
     * 插入测试数据
     */
    Person add(Person person);
    /**
     * Created By zhangkun01 on 16:14 2017/8/22.
     * 批量查询测试数据
     */
    void bulkIndex(List<Person> personList);
    /**
     * Created By zhangkun01 on 16:23 2017/8/22.
     * 查询 lat-纬度 lon-经度
     */
    List<Person> query(Double lat, Double lon);
}

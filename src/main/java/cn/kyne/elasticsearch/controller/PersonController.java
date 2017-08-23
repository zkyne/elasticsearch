package cn.kyne.elasticsearch.controller;

import cn.kyne.elasticsearch.model.Person;
import cn.kyne.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangkun01 on 2017/8/22.
 */
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * Created By zhangkun01 on 16:31 2017/8/22.
     * 批量添加测试数据
     * Spring4.3中引进了｛@GetMapping、@PostMapping、@PutMapping、@DeleteMapping、@PatchMapping｝@GetMapping是一个组合注解，
     * 是@RequestMapping(method = RequestMethod.GET)的缩写
     */
    @GetMapping("/add")
    public String add(){
        double lat = 39.929986;
        double lon = 116.395645;

        List<Person> personList = new ArrayList<>(900000);
        for (int i = 100000; i < 1000000; i++) {
            double max = 0.00001;
            double min = 0.000001;
            Random random = new Random();
            double s = random.nextDouble() % (max - min + 1) + max;
            DecimalFormat df = new DecimalFormat("######0.000000");
            // System.out.println(s);
            String lons = df.format(s + lon);
            String lats = df.format(s + lat);
            Double dlon = Double.valueOf(lons);
            Double dlat = Double.valueOf(lats);
            Person person = new Person();
            person.setId(i);
            person.setName("名字" + i);
            person.setPhone("电话" + i);
            person.setAddress(dlat + "," + dlon);

            personList.add(person);
        }
        personService.bulkIndex(personList);

//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery("spring boot OR 书籍")).build();
//        List<Article> articles = elas、ticsearchTemplate.queryForList(se、archQuery, Article.class);
//        for (Article article : articles) {
//            System.out.println(article.toString());
//        }
        return "add data success";
    }

    /**
     * Created By zhangkun01 on 16:35 2017/8/22.
     * 查询
     */
    @GetMapping("/query")
    public List<Person> query(){
        double lat = 39.929986;
        double lon = 116.395645;
        Long startTime = System.currentTimeMillis();
        List<Person> personList = personService.query(lat,lon);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        return personList;
    }

}

package cn.kyne.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.io.Serializable;

/**
 * Created by zhangkun01 on 2017/8/22.
 * Model类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="elastic_search_project",type="person",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Person implements Serializable{

    private static final long serialVersionUID = 847527021955179738L;

    @Id
    private int id;
    private String name;
    private String phone;
    /**
     * 地理位置经纬度
     * lat纬度，lon经度 "40.715,-74.011"
     * 如果用数组则相反[-73.983, 40.719]
     */
    @GeoPointField
    private String address;
}

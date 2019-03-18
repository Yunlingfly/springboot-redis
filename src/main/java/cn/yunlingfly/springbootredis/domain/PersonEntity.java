package cn.yunlingfly.springbootredis.domain;

import lombok.Data;
import org.springframework.cache.annotation.CacheConfig;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "person_list")
@CacheConfig(cacheNames = "persons")
public class PersonEntity implements Serializable {
    @Id
    private String id;
    private String password;
    private String email;
    private String description;
    private Integer vcode;
    private String avatar;
}

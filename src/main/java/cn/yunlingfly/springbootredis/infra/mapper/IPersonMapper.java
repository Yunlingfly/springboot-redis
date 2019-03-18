package cn.yunlingfly.springbootredis.infra.mapper;

import cn.yunlingfly.springbootredis.domain.PersonEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

// 使用通用mapper
@Component
public interface IPersonMapper extends Mapper<PersonEntity> {
    @Select("select * from person_list where id = #{id}")
    PersonEntity findById(@Param("id") String id);

    @Update("update person_list set password=#{password} where id=#{id}")
    void updateById(PersonEntity personEntity);

    // 如果指定为 true，则方法调用后将立即清空所有缓存
    @Delete("delete from person_list where id=#{id}")
    void deleteById(@Param("id") String id);
}

package com.dty.community.mapper;

import com.dty.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void  create(Question question);
@Select("SELECT * FROM  question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size")Integer size);
@Select("SELECT count(1) FROM  question")
    Integer count();
    @Select("SELECT * FROM  question where creator=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size")Integer size);
    @Select("SELECT count(1) FROM  question where creator =#{userId}")
    Integer countByUserId(@Param("userId")Integer userId);
    @Select("SELECT * FROM  question where id=#{id}")
    Question getById(@Param("id")Integer id);
}

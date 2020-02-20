package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExtMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QUESTION
     *
     * @mbg.generated Sun Feb 09 18:38:22 CST 2020
     */
    int incView(@Param("record") Question record);
    int incCommentCount(@Param("record") Question record);
    List<Question> selectRelated(Question question);

}
package life.majiang.community.dto;

import lombok.Data;

/**
 * Created by fanshijun on 2020/2/13.
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}

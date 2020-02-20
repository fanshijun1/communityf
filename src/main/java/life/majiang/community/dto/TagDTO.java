package life.majiang.community.dto;

import lombok.Data;
import java.util.List;

/**
 * Created by fanshijun on 2020/2/20.
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}


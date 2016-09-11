package kettsuninc.android_dev_templete.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by yuji on 16/09/11.
 */
public class PostEntity {
    String id;
    String theme;
    String contentUri;
    String comment;
    List<TagEntity> tags;
    int likesCount;
    Date createdAt;
    Date updatedAt;
}

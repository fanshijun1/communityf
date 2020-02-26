package life.majiang.community.enums;

/**
 * Created by fanshijun on 2020/2/23.
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);
    private int status;

    NotificationStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

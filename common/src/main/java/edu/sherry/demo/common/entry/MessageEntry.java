package edu.sherry.demo.common.entry;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 消息实体对象
 */
@Data
public class MessageEntry implements Serializable{

    private Integer id;

    private String message;

    private Map<Object, Object> mapMessage;

    private List<Object> listMessage;

    public MessageEntry(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageEntry{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", mapMessage=" + mapMessage.toString() +
                ", listMessage=" + listMessage.toString() +
                '}';
    }
}

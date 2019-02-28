package ru.job4j.tracker;

/**
 * Заявка
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 */

public class Item {

    private String name;
    private String id;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc, long create) {
        this.name = name;
        this.desc = desc;
        this.created = create;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}

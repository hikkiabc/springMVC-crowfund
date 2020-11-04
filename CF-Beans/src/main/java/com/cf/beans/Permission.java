package com.cf.beans;

import java.util.List;

public class Permission {
    private Integer id;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", open=" + open +
                ", children=" + children +
                ", cheked=" + checked +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    private Boolean open=true;
private List<Permission> children;

private  Boolean checked =false;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    private String name;

    private Integer pid;

    private String icon;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

}
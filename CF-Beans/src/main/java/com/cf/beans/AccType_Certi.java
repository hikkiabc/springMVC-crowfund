package com.cf.beans;

public class AccType_Certi {
    private Integer id;

    private Integer accType;

    private Integer certiId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccType() {
        return accType;
    }

    public void setAccType(Integer accType) {
        this.accType = accType;
    }

    public Integer getCertiId() {
        return certiId;
    }

    public void setCertiId(Integer certiId) {
        this.certiId = certiId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accType=").append(accType);
        sb.append(", certiId=").append(certiId);
        sb.append("]");
        return sb.toString();
    }
}
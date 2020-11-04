package com.cf.beans;

public class Ticket {
    private Integer id;

    private Integer memberId;

    private String procid;

    private String captcha;

    private String step;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getProcid() {
        return procid;
    }

    public void setProcid(String procid) {
        this.procid = procid == null ? null : procid.trim();
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", procid=").append(procid);
        sb.append(", captcha=").append(captcha);
        sb.append(", step=").append(step);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}
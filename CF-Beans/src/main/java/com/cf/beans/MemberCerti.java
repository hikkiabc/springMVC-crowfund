package com.cf.beans;

import org.springframework.web.multipart.MultipartFile;

public class MemberCerti {
    private Integer certiId;
    private MultipartFile multipartFile;
    private Integer memberId;
    private String filename;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public MemberCerti(Integer certiId, MultipartFile multipartFile, Integer memberId, String filename) {
        this.certiId = certiId;
        this.multipartFile = multipartFile;
        this.memberId = memberId;
        this.filename = filename;
    }

    public MemberCerti() {
    }

    @Override
    public String toString() {
        return "MemberCerti{" +
                "certiId='" + certiId + '\'' +
                ", multipartFile=" + multipartFile +
                ", memberId=" + memberId +
                ", filename='" + filename + '\'' +
                '}';
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public MemberCerti(Integer certiId, MultipartFile multipartFile, String filename) {
        this.certiId = certiId;
        this.multipartFile = multipartFile;
        this.filename = filename;
    }

    public Integer getcertiId() {
        return certiId;
    }

    public void setcertiId(Integer certiId) {
        this.certiId = certiId;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}

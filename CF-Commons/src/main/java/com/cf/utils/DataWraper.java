package com.cf.utils;

import com.cf.beans.MemberCerti;

import java.util.List;

public class DataWraper {
    private List<MemberCerti> memberCertis;

    public DataWraper() {
    }

    public List<MemberCerti> getMemberCertis() {
        return memberCertis;
    }

    public void setMemberCertis(List<MemberCerti> memberCertis) {
        this.memberCertis = memberCertis;
    }

    @Override
    public String toString() {
        return "DataWraper{" +
                "memberCertis=" + memberCertis +
                '}';
    }
}

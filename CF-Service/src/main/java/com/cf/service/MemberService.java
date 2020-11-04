package com.cf.service;

import com.cf.beans.Member;
import com.cf.beans.MemberCerti;

import java.util.List;
import java.util.Map;

public interface MemberService {

    Member login(Map<String, Object> map);

    Integer updateAccTypeById(Member user);

    List queryCertiByAccType(Integer accType);

    Integer insertMemberCerti(List<MemberCerti> memberCertis);

    void updateStatus(Member user);

    Member queryMemberByInsId(String processDefinition);

    List<Map> queryCertiByMemberId(Integer id);

    Member queryMemberById(Integer id);
}

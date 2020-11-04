package com.cf.dao;

import com.cf.beans.Member;
import com.cf.beans.MemberCerti;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    Member selectByPrimaryKey(Integer id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

    Member login(Map<String, Object> map);

    Integer updateAccTypeById(Member user);

    List queryCertiByAccType(Integer id);

    Integer insertMemberCerti(List<MemberCerti> memberCertis);

    void updateStatus(Member user);

    Member queryMemberByInsId(String processInstanceId);

    List<Map> queryCertiByMemberId(Integer id);
}
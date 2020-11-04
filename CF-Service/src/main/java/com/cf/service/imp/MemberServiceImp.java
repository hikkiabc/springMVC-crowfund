package com.cf.service.imp;

import com.cf.beans.Member;
import com.cf.beans.MemberCerti;
import com.cf.dao.MemberMapper;
import com.cf.exception.LoginFailException;
import com.cf.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public Member login(Map<String, Object> map) {
        Member member = memberMapper.login(map);
        if (member==null) throw new LoginFailException("Wrong Username or Password");
        return member;
    }

    @Override
    public Integer updateAccTypeById(Member user) {
        return memberMapper.updateAccTypeById(user);
    }

    @Override
    public List queryCertiByAccType(Integer accType) {
        return memberMapper.queryCertiByAccType(accType);
    }

    @Override
    public Integer insertMemberCerti(List<MemberCerti> memberCertis) {
        return memberMapper.insertMemberCerti(memberCertis);
    }

    @Override
    public void updateStatus(Member user) {
        memberMapper.updateStatus(user);
    }

    @Override
    public Member queryMemberByInsId(String processInstanceId) {
        return memberMapper.queryMemberByInsId(processInstanceId);
    }

    @Override
    public List<Map> queryCertiByMemberId(Integer id) {
        return memberMapper.queryCertiByMemberId(id);
    }

    @Override
    public Member queryMemberById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}

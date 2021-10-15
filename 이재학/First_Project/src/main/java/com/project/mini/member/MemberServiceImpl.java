package com.project.mini.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void signUp(MemberVO vo) {
		memberDAO.signUp(vo);
	}

	@Override
	public boolean checkDuplicate(MemberVO vo) {
		if(memberDAO.checkDuplicate(vo) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}
	
	
	@Override
    public MemberVO login(MemberVO vo) throws Exception{
        return memberDAO.login(vo);
	}

	@Override
	public List<MemberVO> memberList(MemberVO vo) {
		return memberDAO.memberList(vo);
	}
	
	

}

package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// 회원가입
	public void join(UserVo vo) {
		userRepository.insert(vo);
	}

	// id중복확인 / select * from user where id = id
	public UserVo getUser(String id) {
		return userRepository.findById(id);
	}
	
	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	// 수정 완료
	public UserVo getUser(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	public void updateUser(UserVo userVo) {
		userRepository.update(userVo);
	}


}

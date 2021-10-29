package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.GuestbookRepository;
import com.douzone.jblog.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getMessageList() {
			return guestbookRepository.findAll();
	}
	
	public boolean deleteMessage(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		return guestbookRepository.delete(vo);
	}

	public boolean addMessage(GuestbookVo vo) {
		return guestbookRepository.insert(vo);
	}
}

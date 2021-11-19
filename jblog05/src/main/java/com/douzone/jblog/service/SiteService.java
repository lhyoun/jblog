package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.SiteRepository;
import com.douzone.jblog.vo.SiteVo;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;

	public SiteVo getSite() {
		return siteRepository.find();
	}

	public boolean update(SiteVo siteVo) {
		return siteRepository.update(siteVo);
	}
}

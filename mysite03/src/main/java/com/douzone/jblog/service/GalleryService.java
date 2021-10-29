package com.douzone.jblog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.GalleryRepository;
import com.douzone.jblog.vo.GalleryVo;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryRepository;

	public List<GalleryVo> getImages() {
		return galleryRepository.findAll();
	}
	
	public Boolean removeImage(Long no) {
		return galleryRepository.delete(no);
	}
	
	public Boolean saveImage(GalleryVo vo) {
		return galleryRepository.insert(vo);
	}
}

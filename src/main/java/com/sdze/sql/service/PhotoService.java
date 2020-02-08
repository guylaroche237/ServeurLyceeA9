package com.sdze.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.sql.entite.Photo;
import com.sdze.sql.metier.PhotoMetier;
import com.sdze.sql.repository.PhotoRepository;

@Service
public class PhotoService implements PhotoMetier {
	
	@Autowired
	private PhotoRepository photorep;

	@Override
	public void savePhoto(MultipartFile f,String k) {
		// TODO Auto-generated method stub
		try {
			System.out.println("---------------- debut save file ------------------------");
			String name = f.getOriginalFilename();
			System.out.println("nom fichier:"+name);
			byte[] pic = f.getBytes();
			System.out.println("photo fichier:"+name);
			Photo pho = new Photo(name,pic,k);
			
			photorep.save(pho);
			System.out.println("---------------- FIN FIN SAUVEGARDER AVEC SUCCESS  ------------------------");
			
		}catch(Exception e) {
			System.out.println("----------------  Message d'erreur :"+e.getMessage());
			
		}
		
		
		
	}

	@Override
	public Photo getPhotoById(Long id) {
		// TODO Auto-generated method stub
		return photorep.getOne(id);
	}

}

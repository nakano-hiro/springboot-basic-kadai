package com.example.samuraitravel.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.form.HouseEditForm;
import com.example.samuraitravel.form.HouseRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;

@Service
public class HouseService {
	private final HouseRepository houseRepository;

	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	// すべての民宿をページングされた状態で取得する
	public Page<House> findAllHouses(Pageable pageable) {
		return houseRepository.findAll(pageable);
	}

	// 指定されたキーワードを民宿名に含む民宿を、ページングされた状態で取得する
	public Page<House> findHousesByNameLike(String keyword, Pageable pageable) {
		return houseRepository.findByNameLike("%" + keyword + "%", pageable);
	}

	// 指定したidを持つ民宿を取得する
	public Optional<House> findHouseById(Integer id) {
		return houseRepository.findById(id);
	}

	// 民宿のレコード数を取得する
	public long countHouses() {
		return houseRepository.count();
	}

	// idが最も大きい民宿を取得する
	public House findFirstHouseByOrderByIdDesc() {
		return houseRepository.findFirstByOrderByIdDesc();
	}

	// データの登録
	@Transactional
	public void createHouse(HouseRegisterForm houseRegisterForm) {
		House house = new House();
		MultipartFile imageFile = houseRegisterForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			house.setImageName(hashedImageName);
		}

		house.setName(houseRegisterForm.getName());
		house.setDescription(houseRegisterForm.getDescription());
		house.setPrice(houseRegisterForm.getPrice());
		house.setCapacity(houseRegisterForm.getCapacity());
		house.setPostalCode(houseRegisterForm.getPostalCode());
		house.setAddress(houseRegisterForm.getAddress());
		house.setPhoneNumber(houseRegisterForm.getPhoneNumber());

		houseRepository.save(house);
	}
	
	 @Transactional
	    public void updateHouse(HouseEditForm houseEditForm, House house) {
	        MultipartFile imageFile = houseEditForm.getImageFile();

	        if (!imageFile.isEmpty()) {
	            String imageName = imageFile.getOriginalFilename();
	            String hashedImageName = generateNewFileName(imageName);
	            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
	            copyImageFile(imageFile, filePath);
	            house.setImageName(hashedImageName);
	        }

	        house.setName(houseEditForm.getName());
	        house.setDescription(houseEditForm.getDescription());
	        house.setPrice(houseEditForm.getPrice());
	        house.setCapacity(houseEditForm.getCapacity());
	        house.setPostalCode(houseEditForm.getPostalCode());
	        house.setAddress(houseEditForm.getAddress());
	        house.setPhoneNumber(houseEditForm.getPhoneNumber());

	        houseRepository.save(house);
	    }
	 
	 @Transactional
	    public void deleteHouse(House house) {
	        houseRepository.delete(house);
	    }

	// UUIDを使って生成したファイル名を返す
	// ファイル名の重複を防ぐため、アップロードされた画像ファイルの名前はUUIDで別名に変更する
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");

		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}

		String hashedFileName = String.join(".", fileNames);

		return hashedFileName;
	}

	// 画像ファイルを指定したファイルにコピーする
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
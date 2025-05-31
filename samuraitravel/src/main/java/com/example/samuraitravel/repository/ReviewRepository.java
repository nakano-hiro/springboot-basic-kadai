package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	// 定の民宿に対する最新の【戻り値：レビュー】6件を取得し、＜リスト形式＞で出力する。
	public List<Review> findTop6ByHouseOrderByCreatedAtDesc(House house);

	// 特定の民宿とユーザーに紐づく【戻り値：レビュー】を取得し、該当エンティティを出力する
	public Review findByHouseAndUser(House house, User user);
	
	public long countByHouse(House house);
	
	public Page<Review> findByHouseOrderByCreatedAtDesc(House house, Pageable pageable);

}

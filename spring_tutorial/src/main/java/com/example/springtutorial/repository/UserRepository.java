package com.example.springtutorial.repository;

// リポジトリ（Repository）は、データベースのCRUD（作成・読み取り・更新・削除）機能を提供するインターフェース
// インターフェース：クラスの実装ルールを取り決めるためのテンプレート

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtutorial.entity.User;

// リポジトリはインターフェイス。
// 使うときは以下のように「JpaRepositoryを継承」する。
// extends JpaRepository<エンティティ名, 主キーのデータ型>
public interface UserRepository extends JpaRepository<User, Integer> {

	// ユーザー名で完全一致検索
	// ※フィールド名はアッパーキャメルケースにしないとだめ
	List<User> findByUserName(String userName);
}
package com.example.springtutorial.entity;

// 【エンティティとは】
// テーブルの１行１行（レコード）を実体化し、各カラムへのアクセス手段を提供するクラスのこと
// データベース ←→ エンティティ ←→ リポジトリ


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// lombokを使えばゲッター・セッターを自動生成できる。アウトラインで確認可能
import lombok.Data;


// やること①：クラスの定義

@Entity // クラスをエンティティとして機能させる
@Table(name = "users") // クラスにデータベースのテーブルを紐づける
@Data // Lombokでゲッターセッターを自動生成する



// やること②：フィールドの定義

public class User {
    @Id // フィールドを主キーのカラムとして機能させる
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーのカラムに設定する値を自動生成する
    @Column(name = "user_id") // フィールドにデータベースのカラムを紐づける。主キーにもそれ以外にも必要
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;
}
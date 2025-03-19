package com.example.springtutorial.service;

// サービス（service）は、アプリの仕様に応じた 「ビジネスロジック」 を担当するクラス
// ビジネスロジックとは、そのアプリ固有の処理やルールを実現するプログラム
// たとえば、「ユーザーを登録する」「重複したユーザー名はエラーにする」など
// そのビジネスロジックを実現するために、サービスが具体的なデータ処理の手続きを行う

// サービスは、依存性の注入（DI） というSpring Bootの機能を使うことで、リポジトリを利用する
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springtutorial.entity.User;
import com.example.springtutorial.repository.UserRepository;


// ①クラスの定義：、@Serviceアノテーションをつける
@Service
public class UserService {
    private final UserRepository userRepository;
    
    // ②サービスからリポジトリを利用するために、前述の依存性の注入（DI）で取り込む
    // ※コンストラクタが複数あるときは、依存性を注入したいものに@Autowiredアノテーションが必要(今回は1つしかないのでない)
    // 依存性の注入（DI）を行う（コンストラクタインジェクション）
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    // ③メソッドの定義：DIにより取り込んだリポジトリを用いつつ、各ビジネスロジック用のメソッドを定義する

    // 新規ユーザーの登録メソッド
    public void createUser(String userName, String password, int roleId) {
        // ユーザー名の未入力チェック（空欄はNG）
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("ユーザー名を入力してください。");
        }

        // ユーザー名の重複チェック（完全一致はNG）
        if (!userRepository.findByUserName(userName).isEmpty()) {
            throw new IllegalArgumentException("そのユーザー名は既に使用されています。");
        }

        // ユーザー登録用のエンティティを作成
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setRoleId(roleId);

        // ユーザーの登録
        userRepository.save(user);
    }

    // ユーザーの一括取得メソッド
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
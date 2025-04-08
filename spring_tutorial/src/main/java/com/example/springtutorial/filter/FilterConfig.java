package com.example.springtutorial.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	// FilterRegistrationBeanクラスを使う。
	// 戻り値の型をFilterRegistrationBean<フィルタークラス名>
	// また、@Beanアノテーションで戻り値をDIコンテナに登録
    @Bean
    FilterRegistrationBean<HeaderFooterFilter> registerCorrectFilter() {

        // フィルター登録用のオブジェクトを生成
        FilterRegistrationBean<HeaderFooterFilter> regBean = new FilterRegistrationBean<>();

        // フィルターを設定
        regBean.setFilter(new HeaderFooterFilter());

        // 全リクエスト・レスポンスがフィルターの対象
        regBean.addUrlPatterns("/*");

        // オブジェクトを返すことでDIコンテナに登録
        return regBean;
    }
}
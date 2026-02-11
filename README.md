# 生徒管理システム (Java Spring Boot)

## 概要
Spring Boot + PostgreSQL (Render) + Thymeleaf を使用した、簡易的な生徒登録システム。

## 実装済み機能
- PostgreSQLへの自動テーブル作成 (Hibernate)
- POSTメソッドによる生徒情報の登録
- Thymeleafによる生徒一覧の動的表示

## 起動方法
1. RenderでPostgreSQLを作成
2. `application.properties` に接続情報を設定
3. `./mvnw spring-boot:run` で起動
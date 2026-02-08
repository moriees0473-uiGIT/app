# --- 1. ビルド作業をするステージ（工場） ---
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
# テストをスキップして、本番用の.jarファイルを作る
RUN mvn clean package -DskipTests

# --- 2. 実行するだけのステージ（店舗） ---
FROM eclipse-temurin:21-jre
WORKDIR /app
# 工場で作った .jar ファイルだけをコピーしてくる
COPY --from=builder /app/target/*.jar app.jar

# Renderが決めたポート番号を使うための設定
ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
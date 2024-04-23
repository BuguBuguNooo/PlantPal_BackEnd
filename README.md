# PlantPal

PlantPal 是一个使用 Spring Boot 构建的后端服务，专为植物爱好者设计，适配于常见的植物物联网养护培养箱的APP端的后端程序。可提供在App端的植物环境监测、植物情况监测、可视化和培养箱远程控制等（部分未做完）。

## 功能

- **实时数据通信**: 利用 WebSocket 实现实时数据更新。
- **用户认证与授权**: 提供用户注册、登录以及权限验证功能。
- **数据持久化**: 使用 MyBatis 框架与数据库交互，持久化用户和植物数据。

## 技术栈

- **Spring Boot**: 为主框架。
- **MyBatis**: ORM 框架用于数据层的操作。
- **WebSocket**: 支持实时数据传输。
- **Maven**: 项目管理和构建工具。

## 开始使用

### 环境要求

- JDK 11 或更高版本
- Maven 3.6 或更高版本
- MySQL 数据库
- 
### 安装步骤

1. 克隆仓库到本地: git clone [仓库链接]
2. 2. 在项目根目录下运行 Maven 构建: ./mvnw clean install
3. 修改 `src/main/resources/application.properties` 文件中的数据库配置信息。
4. 运行应用: ./mvnw spring-boot:run

## 结构说明
PlantPal/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.gfj.plantpal/
│ │ │ ├── PlantPalApplication.java
│ │ │ ├── Controller/
│ │ │ ├── Service/
│ │ │ ├── Mapper/
│ │ │ ├── Config/
│ │ │ ├── Pojo/
│ │ │ ├── Interceptor/
│ │ │ ├── WebSocketServer/
│ │ │ ├── Util/
│ │ │ └── ServiceUtil/
│ │ └── resources/
│ │ ├── static/
│ │ ├── templates/
│ │ ├── application.properties
│ │ └── mybatis-config.xml
│ └── test/
├── pom.xml
├── README.md
└── HELP.md

## 贡献指南

欢迎贡献！请查阅 `CONTRIBUTING.md` 了解如何为项目做出贡献。

## 许可证

本项目采用 [MIT 许可证](LICENSE)。

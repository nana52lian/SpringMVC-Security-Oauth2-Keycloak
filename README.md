# SpringMVC-Security-Oauth2-Keycloak
配置文件方式整合keycloak(支持注解Spring4)

Security-OAuth2配置
主要JAR包：spring-security-oauth2 支持配置文件形式
注：spring-security-oauth2 官方不推荐，且其中OAuth2RestTemplate等CLASS失效。
若采用spring-security-oauth2-core / spring-security-oauth2-client 等JAR代替，则不支持配置文件（META-INF中缺少scheme）。

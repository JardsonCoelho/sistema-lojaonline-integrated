Loja Online - Integrated (Backend + Frontend static SPA)

Estrutura:
- Backend: Spring Boot (src/main/java)
- Frontend: Static SPA em src/main/resources/static (index.html, app.js, styles.css)
- API: /api/produtos (CRUD)

Como rodar (local):
1. Configure um PostgreSQL local com banco 'lojaonline' e usuário/senha conforme src/main/resources/application.properties
2. Build: mvn clean package
3. Run: java -jar target/sistema-lojaonline-1.0.0.jar
4. Acesse: http://localhost:8080/

Observações:
- A interface é uma SPA simples que consome /api/produtos.
- Para testes rápidos, insira registros diretamente no DB ou use endpoints POST /api/produtos.

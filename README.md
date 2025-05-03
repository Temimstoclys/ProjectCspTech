# 🧪 Testes Automatizados com Selenium e Cucumber

Este projeto realiza testes automatizados de funcionalidades **CRUD** (criação, visualização, edição e exclusão de contas) e login em um sistema web, utilizando **Java 17, Selenium WebDriver, Cucumber e JUnit 5**.

## 📌 Tecnologias Utilizadas

- Java 17
- Maven
- Selenium WebDriver
- Cucumber
- JUnit 5
- GitHub Actions (CI/CD)

---

## 🚀 Como executar os testes localmente

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio

```

### 2. Instalar as dependências

```bash
mvn clean install
```

### 3. Executar os testes

```bash
mvn test
```

---

## 🔁 Pipeline CI/CD

A execução dos testes é feita automaticamente por meio do **GitHub Actions**, em duas situações:

- A cada novo **push** no repositório.
- Manualmente via **workflow_dispatch** (botão "Run workflow").

### 🛠️ Arquivo `.github/workflows/main.yml`

```yaml
name: CI/CD Pipeline

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test-spec:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v3

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Instalar dependências
        run: |
          sudo apt-get update
          sudo apt-get install -y wget curl unzip xvfb libxi6 default-jdk

      - name: Instalar Chrome 136
        run: |
          wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
          sudo dpkg -i google-chrome-stable_current_amd64.deb || sudo apt-get -f install -y
          google-chrome --version

      - name: Baixar ChromeDriver 136 compatível
        run: |
          DRIVER_URL="https://storage.googleapis.com/chrome-for-testing-public/136.0.7103.49/linux64/chromedriver-linux64.zip"
          wget $DRIVER_URL -O chromedriver.zip
          unzip chromedriver.zip
          sudo mv chromedriver-linux64/chromedriver /usr/local/bin/
          sudo chmod +x /usr/local/bin/chromedriver

      - name: Verificar versões
        run: |
          google-chrome --version
          chromedriver --version

      - name: Executar testes com Maven
        run: mvn clean test -Dbrowser=chrome

      - name: Gerar relatório HTML do Cucumber
        run: mvn verify

      - name: Publicar relatório como artefato
        uses: actions/upload-artifact@v4
        with:
          name: cucumber-report-html
          path: target/cucumber-report-html

```

---

## 📂 Estrutura do Projeto

```
src/
├── test/
│   ├── java/
│   │   ├── pages/          # Page Objects com os elementos e ações
│   │   ├── runners/        # Classe de execução dos testes Cucumber
│   │   ├── steps/          # Definições dos steps do Cucumber
│   │   └── support/        # Base, utilitários e configuração do WebDriver
│   └── resources/
│       ├── features/       # Arquivos .feature com os cenários
│       ├── drivers/        # WebDrivers para Chrome e Edge
│       ├── config.properties
│       └── cucumber.properties

```

---

## ✅ Requisitos Atendidos

- ✔️ Testes automatizados para ambiente web  
- ✔️ Integração contínua com GitHub Actions  
- ✔️ Execução automática via push ou manual via botão

---

💬 Em caso de dúvidas ou sugestões, fique à vontade para abrir uma [issue](https://github.com/seu-usuario/nome-do-repositorio/issues).
# 🧪 Projeto de Testes Automatizados com Selenium e Cucumber

Este projeto realiza testes automatizados de funcionalidades **CRUD** (criação, visualização, edição e exclusão de contas) em um sistema web, utilizando **Java, Selenium WebDriver, Cucumber e JUnit**.

## 📌 Tecnologias Utilizadas

- Java 11+
- Maven
- Selenium WebDriver
- Cucumber
- JUnit
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

### 🛠️ Arquivo `.github/workflows/ci.yml`

```yaml
name: Execução de Testes Automatizados

on:
  push:
  workflow_dispatch:

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout do código
        uses: actions/checkout@v3

      - name: Setup do Java
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

      - name: Build com Maven
        run: mvn clean install

      - name: Executar testes
        run: mvn test
```

---

## 📂 Estrutura do Projeto

```
src/
├── test/java/
│   ├── steps/          # Definições dos steps do Cucumber
│   ├── pages/          # Page Objects com os elementos e ações
│   ├── runners/        # Classe de execução dos testes Cucumber
│   └── support/        # Suporte como WebDriverFactory, Hooks etc.
├── resources/
│   └── features/       # Arquivos .feature com os cenários
```

---

## ✅ Requisitos Atendidos

- ✔️ Testes automatizados para ambiente web  
- ✔️ Integração contínua com GitHub Actions  
- ✔️ Execução automática via push ou manual via botão

---

💬 Em caso de dúvidas ou sugestões, fique à vontade para abrir uma [issue](https://github.com/seu-usuario/nome-do-repositorio/issues).
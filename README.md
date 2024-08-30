# Projeto Java CI/CD

## Descrição

Projeto Java que utiliza Maven para construção e testes. O processo de CI/CD é gerenciado usando GitHub Actions, e a análise de qualidade do código é feita com SonarCloud. O fluxo de trabalho inclui construção, testes, análise de código e deploy em ambientes sandbox e produção.

## Estrutura do Repositório

- **`src/`**: Código-fonte do projeto.
- **`pom.xml`**: Arquivo de configuração do Maven.
- **`.github/workflows/`**: Diretório contendo os arquivos de configuração do GitHub Actions.

## Configuração do CI/CD

O processo de CI/CD é gerenciado por meio dos seguintes arquivos de configuração:

### GitHub Actions Workflow

Foram criados 3 arquivos `.yaml` para o fluxo de CI/CD. Sendo eles:

1. **workflow-tests.yaml**
    - Executa testes e constrói o projeto Java usando Maven.
    - Analisa o código com SonarCloud para garantir a qualidade.
    - Realiza o build da imagem Docker e publica no Dockerhub.
> **Observação:** Esta etapa é executada a cada push no repositório. 

2. **workflow-sandbox.yaml**
    - Realiza o deploy em um ambiente de sandbox para testes.
> **Observação:** Esta etapa de deploy para sandbox é realizada apenas quando realizado um comentário no pull request com a palavra-chave **/ok-to-sandbox**.

3. **workflow-prod.yaml**
   - Realiza o deploy no ambiente de produção.
> **Observação:** Esta etapa é realizada automaticamente quando o pull request é mesclado.

# FIAP MPEG Notificator

Sistema responsável por gerenciar e enviar notificações relacionadas ao processamento de vídeos, utilizando **AWS SQS** para filas de mensagens e **Java Spring Boot** como framework backend

## 📜 Funcionalidades

- **Envio de Emails**: Utiliza SMTP para notificações relacionadas ao processamento de arquivos.
- **Consumo de Mensagens**: Processamento de mensagens provenientes de filas **AWS SQS**.
- **Validação de Dados**: Garante a integridade dos dados recebidos antes do processamento.
- **Gerenciamento de Protocolo**: Integração com sistemas externos para monitoramento de arquivos processados.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.1**
    - Spring Mail
    - Spring Validation
    - Spring Web
- **AWS SQS** (via `spring-cloud-aws-starter-sqs`)
- **Mockito e JUnit 5** (para testes unitários)
- **Maven** (gerenciamento de dependências)

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 17** instalado
- **Maven** instalado
- Configuração de uma fila **AWS SQS**
- Servidor SMTP configurado (ex.: Gmail, Mailtrap)

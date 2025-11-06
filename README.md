# 🔐 API de Autenticação com Spring Boot, Spring Security e JWT

Uma aplicação RESTful desenvolvida com **Spring Boot** que implementa **autenticação e autorização seguras** usando **JWT (JSON Web Token)**.  
O projeto segue boas práticas modernas de segurança, com criptografia de senhas via **BCrypt**, uso do **Spring Security**, e uma arquitetura limpa e escalável.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|-------------|------------|
| **Java 17+** | Linguagem base do projeto |
| **Spring Boot** | Framework para criação da aplicação |
| **Spring Security** | Módulo responsável pela autenticação e autorização |
| **Spring Data JPA** | Camada de persistência de dados com ORM |
| **Flyway** | Controle de versão do banco de dados |
| **MySQL** | Banco de dados relacional |
| **JWT (Auth0)** | Geração e validação de tokens de acesso |
| **Lombok** | Redução de boilerplate (getters, setters, equals, etc.) |

---

## 🧩 Estrutura do Projeto

src/
└── main/
├── 📦 java/com/seguranca-springdev/
│ ├── 🔐 config/ → Configurações de segurança e autenticação
│ ├── 🚪 controller/ → Endpoints REST
│ ├── 📤 dto/ → Objetos de transferência de dados (Request e Response)
│ ├── 🧍 model/ → Entidades JPA (ex: Usuario)
│ ├── 💾 repository/ → Interfaces de persistência
│ ├── 🧠 service/ → Regras de negócio e autenticação
│ └── 🧱 security/ → Filtros, tokens e classes auxiliares
│
└── 🗂️ resources/
├── ⚙️ application.yml → Configurações do ambiente
└── 🧬 db/migration/ → Scripts Flyway (criação de tabelas)




## ⚙️ Fluxo de Autenticação

1. **Registro de Usuário**
   - O cliente realiza um `POST /auth/registrar`.
   - A senha é **criptografada com BCrypt** antes de ser salva no banco.

2. **Login**
   - O cliente envia `email` e `senha` para `POST /auth/login`.
   - O Spring Security autentica as credenciais usando `UserDetailsService`.
   - Em caso de sucesso, é gerado um **JWT** assinado e retornado ao cliente.

3. **Acesso a Recursos Protegidos**
   - O cliente envia o token JWT no header `Authorization: Bearer <token>`.
   - O Spring valida o token e libera o acesso às rotas autenticadas.

---

## 📬 Endpoints Principais

| Método | Endpoint | Descrição | Acesso |
|:-------|:----------|:-----------|:--------|
| POST | /auth/registrar | Registra um novo usuário | Público |
| POST | /auth/login | Realiza o login e retorna um token JWT | Público |
| GET  | /usuarios | Exemplo de endpoint protegido | Requer JWT |

---

## 🧠 Entidades Importantes

### 🧍‍♂️ `Usuario`
``java
@Entity
@Table(name = "tbusuario")
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha; // Criptografada com BCrypt
}


⚙️ AuthController

Controla o fluxo de login e registro de usuários.

Retorna o token JWT ao usuário após autenticação.

🔒 SecurityConfig

Define as regras de segurança da aplicação.

Libera endpoints públicos (/auth/login, /auth/registrar).

Exige autenticação para os demais.

🪪 TokenConfig

Responsável pela geração e assinatura do JWT.

Define validade, emissor e secret key.

🧰 Como Executar o Projeto
Pré-requisitos

Java 17+

Maven

MySQL rodando localmente

Postman, Insomnia ou similar para testar endpoints







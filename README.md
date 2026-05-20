## 🗄️ Modelo de Dados (Estrutura NoSQL)

Diferente de um modelo relacional (SQL) que utiliza chaves estrangeiras e junções (*joins*) complexas, este projeto utiliza o poder de agregação do MongoDB:

1. **User (Usuário):** Possui `id`, `name` e `email`. Contém uma lista de referências (`@DBRef`) para os posts que publicou (estratégia de carga sob demanda - *lazy loading*).
2. **Post (Publicação):** Possui `id`, `date`, `title`, `body` e um `AuthorDTO` (cópia desnormalizada com `id` e `name` do autor, otimizando a leitura do post sem precisar de uma nova consulta ao usuário).
3. **Comment (Comentário):** Modelado como um subdocumento (`CommentDTO`) aninhado diretamente dentro do documento do `Post`, contendo `text`, `date` e o `AuthorDTO` de quem comentou.

---

## 📌 Endpoints da API (Prontos para o Front-End)

Todos os endpoints retornam dados no formato padrão `application/json`.

### 👥 Usuários (`/users`)
* `GET /users` - Retorna a lista completa de usuários (mapeados para `UserDTO`).
* `GET /users/{id}` - Retorna um usuário específico pelo ID. Lança exceção customizada se não encontrado.
* `POST /users` - Insere um novo usuário. Retorna o cabeçalho `Location` com a URI do novo recurso.
* `PUT /users/{id}` - Atualiza as informações de um usuário existente.
* `DELETE /users/{id}` - Remove um usuário do banco de dados (retorna 204 No Content).
* `GET /users/{id}/posts` - Retorna a lista de posts associados àquele usuário específico.

### 📝 Posts (`/posts`)
* `GET /posts/{id}` - Retorna um post detalhado com seu autor e a lista de comentários aninhados.
* `GET /posts/titlesearch?text=...` - Busca posts por termos contidos no título (*Query Method* do Spring Data).
* `GET /posts/fullsearch?text=...&minDate=...&maxDate=...` - Consulta avançada nativa do MongoDB que filtra posts por texto (no título ou corpo) e por intervalo de datas.

---

## 🛠️ Como Executar o Projeto Localmente

### Pré-requisitos
* Java JDK (versão 17 ou superior) instalado.
* Maven instalado (ou utilizar o wrapper `./mvnw`).
* MongoDB instalado e rodando localmente na porta padrão (`27017`), ou um cluster ativo no MongoDB Atlas.

### Passo a Passo
1. **Clonar o Repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/workshopmongodb.git](https://github.com/seu-usuario/workshopmongodb.git)
   cd workshopmongodb

   * **Foco no Back-End e Prontidão para Front-End:** Explica claramente que a API devolve respostas em formato padrão `application/json` com códigos de status HTTP apropriados (`200 OK`, `201 Created`, `204 No Content`), facilitando o consumo por frameworks como React, Angular ou Vue.
* **Modelagem NoSQL (MongoDB):** Destaca as abordagens de **referenciação** (como ligar os posts aos usuários via `@DBRef`) e **desnormalização/aninhamento** (como embutir os comentários diretamente dentro do documento do Post, melhorando a performance de leitura do banco).
* **Camada DTO (Data Transfer Object):** Evidencia que usou DTOs para trafegar os dados com segurança e otimizar o payload das requisições HTTP.
* **Consultas Avançadas:** Inclui uma secção para os endpoints de busca personalizada, demonstrando proficiência tanto em *Query Methods* quanto em consultas nativas do MongoDB usando a anotação `@Query`.
* **Guia de Execução:** Um passo a passo limpo ensinando como clonar o projeto, configurar a URI de conexão e rodar a aplicação através do terminal ou da IDE (como o IntelliJ).

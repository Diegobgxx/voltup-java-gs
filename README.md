## Projeto VoltUP

## Integrantes
- Paulo César
- Saulo Gomes
- Matheus Valero Colim
- Diego Borges


## Endpoints

### Criar Usuário

- **Método HTTP:** POST
- **URL:** /user
- **Descrição:** Cria um novo usuário com base nos dados fornecidos no corpo da requisição.
- **Corpo da Requisição:** JSON contendo os dados do usuário.
  ```json
  {
    "username": "Nome do Usuário",
    "email": "email@dominio.com",
    "type": "PRODUCER"
  }
  ```
- **Resposta de Sucesso:** Retorna o usuário criado com status 200 OK.

### Buscar Usuário por ID

- **Método HTTP:** GET
- **URL:** /user/{id}
- **Descrição:** Busca um usuário pelo seu ID.
- **Parâmetros de URL:**
    - `{id}`: ID do usuário a ser buscado.
- **Resposta de Sucesso:** Retorna o usuário encontrado com status 200 OK.
- **Resposta de Falha:** Retorna status 404 Not Found se o usuário não for encontrado.

## Como Rodar o Projeto

Para executar este projeto em sua máquina local, siga as instruções abaixo:

1. Certifique-se de que você possui o JDK (Java Development Kit) instalado em sua máquina. Se não tiver, você pode baixá-lo e instalá-lo a partir do [site oficial da Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. Clone este repositório para o seu ambiente local:

   ```bash
   git clone https://github.com/PauloCesarRR/voltup-java.git
   ```

3. Navegue até o diretório raiz do projeto:

   ```bash
   cd voltup-java
   ```

4. Execute o seguinte comando para construir o projeto:

   ```bash
   ./gradlew build
   ```

5. Após a construção ser concluída com sucesso, você pode executar o projeto usando o seguinte comando:

   ```bash
   ./gradlew bootRun
   ```

6. Uma vez que o projeto esteja em execução, os endpoints estarão disponíveis em `http://localhost:8080`.
repositorio
Certifique-se de ter configurado corretamente as credenciais do banco de dados ou qualquer outra configuração necessária para que a aplicação funcione corretamente em seu ambiente local.

Para qualquer dúvida ou problema, sinta-se à vontade para abrir uma nova issue neste repositório.
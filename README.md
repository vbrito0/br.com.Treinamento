# API de Pessoa

## Versão 1.0

Esta é a documentação para a API de Pessoa, que fornece endpoints para gerenciar pessoas e suas variações (Pessoa Física e Pessoa Jurídica). 

## Documentação da API

A documentação está disponível em:

- **Swagger UI:** [http://localhost:8080/pessoa-api/swagger-ui.html](http://localhost:8080/pessoa-api/swagger-ui.html)
- **OpenAPI Specification:** [http://localhost:8080/pessoa-api/v3/api-docs](http://localhost:8080/pessoa-api/v3/api-docs)

## Servidores

- **Servidor Local:** [http://localhost:8080/pessoa-api](http://localhost:8080/pessoa-api)

## Endpoints

### 1. Alterar Pessoa

- **Método:** `PUT`
- **Endpoint:** `/pessoa/alterar/{cpf}`
- **Descrição:** Altera as informações de uma pessoa identificada pelo CPF.
- **Parâmetros de URL:**
  - `cpf` (string): CPF da pessoa a ser alterada.
- **Request Body:**
  - `PessoaDTO`: Dados da pessoa para atualização.
- **Respostas:**
  - `200 OK`: Pessoa alterada com sucesso.
  - `404 Not Found`: Pessoa não encontrada.

### 2. Cadastrar Pessoa

- **Método:** `POST`
- **Endpoint:** `/pessoa/cadastrar`
- **Descrição:** Cadastra uma nova pessoa.
- **Request Body:**
  - `PessoaDTO`: Dados da nova pessoa.
- **Respostas:**
  - `201 Created`: Pessoa cadastrada com sucesso.
  - `400 Bad Request`: Dados inválidos.

### 3. Listar Todas as Pessoas

- **Método:** `GET`
- **Endpoint:** `/pessoa`
- **Descrição:** Lista todas as pessoas cadastradas.
- **Respostas:**
  - `200 OK`: Lista de pessoas.
  - `204 No Content`: Nenhuma pessoa encontrada.

### 4. Buscar Pessoa por CPF

- **Método:** `GET`
- **Endpoint:** `/pessoa/{cpf}`
- **Descrição:** Busca uma pessoa pelo CPF.
- **Parâmetros de URL:**
  - `cpf` (string): CPF da pessoa a ser buscada.
- **Respostas:**
  - `200 OK`: Pessoa encontrada.
  - `404 Not Found`: Pessoa não encontrada.

## Schemas

### PessoaDTO

Representa os dados básicos de uma pessoa.

- `nome` (string): Nome da pessoa.
- `nomeFantasia` (string): Nome fantasia da pessoa (se aplicável).
- `logradouro` (string): Logradouro.
- `numero` (integer): Número do endereço.
- `complemento` (string): Complemento do endereço.
- `bairro` (string): Bairro.
- `cep` (string): CEP.
- `cidade` (string): Cidade.
- `uf` (string): Unidade Federativa.

### PessoaFisicaDTO

Representa os dados específicos de uma pessoa física.

- `cpf` (string): CPF.
- `rg` (string): RG.
- `genero` (string): Gênero (Enumerado).
- `dataNascimento` (string, formato: `yyyy-MM-dd`): Data de nascimento.

### PessoaJuridicaDTO

Representa os dados específicos de uma pessoa jurídica.

- `cnpj` (string): CNPJ.
- `inscricaoEstadual` (string): Inscrição estadual.

### Pessoa

Representa a entidade base para Pessoa.

- `idPessoa` (integer): Identificador da pessoa.
- `nome` (string): Nome da pessoa.
- `nomeFantasia` (string): Nome fantasia da pessoa (se aplicável).
- `logradouro` (string): Logradouro.
- `numero` (integer): Número do endereço.
- `complemento` (string): Complemento do endereço.
- `bairro` (sstring): Bairro.
- `cep` (string): CEP.
- `cidade` (string): Cidade.
- `uf` (string): Unidade Federativa.

### PessoaFisica

Representa uma pessoa física. Estende a entidade `Pessoa`.

- `cpf` (string): CPF.
- `rg` (string): RG.
- `genero` (string): Gênero.
- `dataNascimento` (string, formato: `yyyy-MM-dd`): Data de nascimento.

### PessoaJuridica

Representa uma pessoa jurídica. Estende a entidade `Pessoa`.

- `cnpj` (string): CNPJ.
- `inscricaoEstadual` (string): Inscrição estadual.

## Notas

- Todos os endpoints requerem autenticação.
- As respostas de erro seguem o padrão de status HTTP.

Para mais informações, consulte a documentação completa da API.

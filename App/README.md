# 🍽️ Byte & Brasa — Sistema de Restaurante

## 1. Nome e objetivo do projeto

**Byte & Brasa — Sistema de Restaurante**

O Byte & Brasa é um sistema desenvolvido em Java com o objetivo de facilitar o gerenciamento das operações básicas de um restaurante, permitindo o cadastro de clientes, consulta ao cardápio, gerenciamento de pedidos, cancelamento de itens e consulta de saldo.

O projeto busca aplicar conceitos fundamentais da programação orientada a objetos e estruturas de dados, oferecendo uma solução simples e organizada para o gerenciamento de um restaurante.

## 2. Problema que o sistema pretende resolver

O sistema busca solucionar dificuldades relacionadas ao gerenciamento manual das operações de um restaurante, como:

- Organização e cadastro de clientes.
- Consulta e gerenciamento dos itens disponíveis no cardápio.
- Registro e acompanhamento dos pedidos.
- Cancelamento de itens adicionados incorretamente.
- Consulta do saldo relacionado às operações do restaurante.

Com isso, o sistema procura tornar essas atividades mais organizadas, práticas e eficientes, reduzindo possíveis erros durante o atendimento.

## 3. Integrantes da equipe

- Gabriel Silva Costa
- Isaque Leonez Costa
- Antonio Thiago Santos Gadelha Simas Macedo
- Jeremias Tavares Do Nascimento
- Jhonata Borges Silva Da Costa
- Gabriel Nascimento Serra

*Observação: adicionar os nomes dos demais integrantes, caso o projeto seja desenvolvido em equipe.*

## 4. Principais funcionalidades

O sistema possui as seguintes funcionalidades:

- **Cadastro de clientes:** permite registrar novos clientes no sistema.
- **Listagem de clientes:** permite visualizar os clientes cadastrados.
- **Consulta ao cardápio:** apresenta os itens disponíveis no restaurante.
- **Adicionar item ao pedido:** permite selecionar produtos do cardápio e adicioná-los ao pedido atual.
- **Resumo do pedido:** apresenta os itens selecionados e as informações do pedido.
- **Cancelamento de itens:** permite remover itens adicionados ao pedido.
- **Consulta de saldo:** permite consultar o saldo registrado no sistema.
- **Finalização:** disponibiliza a opção de encerrar o fluxo de utilização do sistema.

## 5. Perfis de acesso e permissões

Na versão atual, o sistema funciona por meio de um menu interativo no terminal, sem autenticação de usuários ou diferenciação de permissões.

**Perfil disponível: Operador do sistema**

Permissões:
- Cadastrar clientes.
- Consultar clientes cadastrados.
- Visualizar o cardápio.
- Adicionar itens aos pedidos.
- Consultar o resumo dos pedidos.
- Cancelar itens dos pedidos.
- Consultar o saldo.
- Finalizar a utilização do sistema.

**Observação:** todas as funcionalidades são disponibilizadas pelo menu principal, sem restrições por nível de acesso.

## 6. Tecnologias utilizadas

O projeto utiliza as seguintes tecnologias e recursos:

- **Java:** linguagem utilizada no desenvolvimento do sistema.
- **Programação Orientada a Objetos (POO):** organização do código em classes e objetos.
- **ArrayList:** estrutura utilizada para armazenar e manipular coleções de dados.
- **List:** interface utilizada para trabalhar com listas.
- **Scanner:** utilizado para receber informações digitadas pelo usuário no terminal.
- **VS CODE:** ambiente de desenvolvimento utilizado no projeto.

## 7. Requisitos para execução

Para executar o projeto, é necessário possuir:

- Java Development Kit (JDK) instalado.
- VS CODE ou outra IDE compatível com Java.
- Terminal ou console para interação com o sistema.
- Arquivos `.java` do projeto, incluindo suas classes auxiliares.

## 8. Passo a passo para compilar e executar o projeto

### 1. Instalar o Java

Instale o JDK e verifique se ele está configurado corretamente.

No terminal, execute:

```bash
java -version
```

Para verificar o compilador:

```bash
javac -version
```

### 2. Obter os arquivos do projeto

Faça o download ou clone do repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd nome-do-projeto
```

### 3. Abrir o projeto

Abra a pasta do projeto no IntelliJ IDEA.

Verifique se todas as classes estão presentes e se o JDK está configurado corretamente.

### 4. Compilar o projeto

Caso os arquivos estejam organizados na pasta `src/App`, abra o terminal na raiz do projeto e execute:

```bash
java -d out src/App/*.java
```

### 5. Executar o sistema

Após a compilação, execute:

```bash
java -cp out App.SistemadeRestaurante
```

**Importante:** os comandos acima consideram que a classe principal se chama `SistemadeRestaurante` e que o pacote utilizado é `App`.

## 9. Estrutura geral das principais classes

O projeto é organizado em classes, cada uma responsável por representar ou controlar uma parte do funcionamento do restaurante.

| Classe | Responsabilidade |
|---|---|
| `SistemadeRestaurante` | Classe principal. Controla o menu e integra as funcionalidades do sistema. |
| `ItemMenu` | Representa os produtos disponíveis no cardápio. |
| `Cadastropessoa` | Responsável pelas informações e pelo cadastro dos clientes. |
| `Pedido` | Gerencia os itens adicionados ao pedido atual. |
| `Cancelamento` | Representa o controle relacionado ao cancelamento de itens. |
| `ConsultarSaldo` | Responsável pela consulta e controle do saldo. |

### Organização das classes

```text
Byte-Brasa/
│
├── src/
│   └── App/
│       ├── SistemadeRestaurante.java
│       ├── ItemMenu.java
│       ├── Cadastropessoa.java
│       ├── Pedido.java
│       ├── Cancelamento.java
│       └── ConsultarSaldo.java
│
└── README.md
```

*Observação: a estrutura apresentada representa a organização prevista das principais classes. Os nomes dos arquivos devem corresponder aos nomes reais utilizados no projeto.*

---

## 10. Considerações finais

O desenvolvimento do Byte & Brasa proporciona a aplicação prática de conceitos de Java, programação orientada a objetos, manipulação de coleções e lógica de programação.

O projeto também permite aprimorar conhecimentos relacionados à organização de código, resolução de problemas e desenvolvimento de sistemas voltados para situações do cotidiano.
#  Requisitos do Sistema

## Requisitos Funcionais (RF)

RF01 – O sistema deve permitir que funcionários da instituição realizem o cadastro de suas contas.

RF02 – O sistema deve permitir que funcionários façam login utilizando seu **NIF (Número de Identidade Funcional)** e senha.

RF03 – O sistema deve permitir o cadastro de **categorias de materiais**, facilitando a organização dos itens do estoque.

RF04 – O sistema deve permitir o cadastro de **materiais utilizados nos laboratórios e salas da unidade escolar**.

RF05 – O sistema deve permitir que os usuários visualizem a **lista de materiais cadastrados no estoque**.

RF06 – O sistema deve permitir **editar ou atualizar as informações de um material**, caso seja necessário corrigir ou alterar algum dado.

RF07 – O sistema deve permitir **remover materiais do sistema**, quando não forem mais utilizados ou estiverem incorretos.

RF08 – O sistema deve permitir registrar **entradas de materiais no estoque**, quando novos itens forem adicionados.

RF09 – O sistema deve permitir registrar **saídas de materiais do estoque**, quando algum item for utilizado ou retirado.

RF10 – O sistema deve permitir visualizar o **histórico de movimentações de estoque**, mostrando entradas e saídas de materiais.

RF11 – O sistema deve permitir o cadastro de **ativos patrimoniais da instituição**, como equipamentos e bens pertencentes à escola.

RF12 – O sistema deve permitir visualizar o **inventário de ativos patrimoniais cadastrados**.

RF13 – O sistema deve permitir que o usuário **encerre sua sessão no sistema (logout)** quando terminar de utilizá-lo.

---

## Requisitos Não Funcionais (RNF)

RNF01 – O sistema deve ser desenvolvido utilizando **Java com o framework Spring Boot**.

RNF02 – O sistema deve utilizar **Spring Data JPA** para facilitar a comunicação com o banco de dados.

RNF03 – A interface do sistema deve ser desenvolvida utilizando **HTML, CSS e Thymeleaf**.

RNF04 – O sistema deve utilizar um **banco de dados relacional**, como H2, MySQL ou PostgreSQL.

RNF05 – A interface do sistema deve ser **simples, organizada e fácil de usar**, permitindo que qualquer funcionário consiga utilizá-la.

RNF06 – O sistema deve seguir o **manual de identidade visual do SENAI-SP**, utilizando as cores, fontes e logotipo corretos.

RNF07 – O acesso ao sistema deve ser **restrito a funcionários autorizados**, garantindo maior segurança das informações.

RNF08 – O projeto deve seguir uma **estrutura organizada em camadas**, separando Model, Repository, Service e Controller.

RNF09 – O sistema deve garantir a **integridade dos dados armazenados no banco**, evitando duplicações ou inconsistências.

RNF10 – O sistema deve ser acessível através de **navegadores web modernos**, como Google Chrome ou Microsoft Edge.

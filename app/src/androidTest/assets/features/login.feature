#language: pt

@feaure_login
Funcionalidade: Login

  Contexto:
    Dado Que eu abra a tela login

  @validate_login_field_errors
  Esquema do Cenario: Validação de erro nos campos de login
    Dado Que eu insira o email "<email>" e senha "<senha>"
    E Eu clique no botão "Login"
    Entao Eu verei no campo a mensagem de erro "<mensagem>"

    Exemplos:
      | email           | senha | mensagem                |
      |                 |       | Informe um email        |
      | email@email.com |       | Digite sua senha        |
      |                 | 123   | Informe um email        |
      | email           | 123   | Informe um email válido |

  @validate_login_error
  Cenario: Validação de erros de login
    Dado Que eu insira o email "a@a.com" e senha "123"
    E Eu clique no botão "Login"
    Entao Eu verei a mensagem no popup "Usuário não encontrado"

  @validate_login_success
  Cenario: Validação de login com sucesso
    Dado Que eu insira o email "email@email.com" e senha "123"
    E Eu clique no botão "Login"
    Entao Eu verei a tela home
#language: pt

@feature_home_logged_in
Funcionalidade: Home logado

  Contexto:
    Dado Que eu abra a tela home com usuário logado

  @home_logged_in_check_tabs
  Cenario: Home tabs
    Entao Eu verei a tab "MOVIE"
    E Eu verei a tab "SERIES"

  @home_logged_in_swipe_left_and_right
  Cenario: Home swipe tabs
    Entao Eu verei a tab "MOVIE" selecionada
    E Eu farei o swipe para a esquerda
    Entao Eu verei a tab "SERIES" selecionada
    E Eu farei o swipe para a direita
    Entao Eu verei a tab "MOVIE" selecionada

  @home_logged_in_select_movie
  Cenario: Home logado
    Quando Eu clicar no primeiro filme
    Entao Eu verei a tela de detalhes do filme

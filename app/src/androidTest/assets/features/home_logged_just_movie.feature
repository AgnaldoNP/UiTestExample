#language: pt

@feature_home_logged_in_just_movie
Funcionalidade: Home logado somente filmes

  Contexto:
    Dado Que a busca por titulos retorne apenas filmes
    E Que eu abra a tela home

  @home_logged_in_only_movie_tab
  Cenario: Verificar somente aba de filmes
    Entao Eu verei a tab "MOVIE" selecionada
    Entao Eu não verei a tab "SERIES"
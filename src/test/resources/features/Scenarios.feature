# language: pt
  Funcionalidade: Account Management

  Contexto:
    Dado que estou logado no sistema

  Cenário: Account Creation
    Quando eu crio uma conta com o nome "Conta Teste"
    Entao  devo ver a mensagem de "Conta adicionada com sucesso!"

  Cenário: Account View
    Quando eu acesso a lista de contas
    Entao  eu devo ver minha "Conta Teste"

  Cenário: Account Editing
    Quando eu edito a conta chamada "Conta Teste" para "Conta Editada"
    Entao  devo ver a mensagem de "Conta alterada com sucesso!"

  Cenário: Account Deletion
    Quando eu excluo a conta chamada "Conta Editada"
    Entao  devo ver a mensagem de "Conta removida com sucesso!"

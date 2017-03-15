
<h1>Sistema para Curso de Inglês<h1>

Objetivos do trabalho

Demonstrar habilidade para desenvolvimento de aplicação Web utilizando:
•	Applets ou JavaScript
•	Java Servlets
•	Tomcat Servlet Container
•	Acesso ao SGBD via JDBC

Demonstrar conhecimento dos seguintes aspectos de programação:
•	Linguagem Java
•	Uso adequado de OO

Trabalho proposto


Escreva uma aplicação Web de gestão de um curso de inglês. A aplicação deverá emitir uma mensagem de erro no caso de campos obrigatórios não preenchidos. As funcionalidades do sistema estão listadas abaixo:

•	Cadastrar Turma
•	Listar Turmas
•	Alterar/Excluir Turma
•	Cadastrar Aluno
•	Matricular Aluno 
•	Buscar Aluno / Registrar Frequência e Nota

Cadastrar turma
O usuário poderá cadastrar novas turmas. Ao cadastrá-las, devem ser informados os seguintes dados:
•	Código (obrigatório, caixa de texto)
•	Nível (radio com as opções. Ex: Básico1, Básico2, Intermediário1, Avançado1, ...)
•	Professor (obrigatório, caixa de texto)
•	Horário (combobox contendo as opções de horários. Ex: 24ABM, 35CDT, 35ABN, ...)
•	Sala (obrigatório, caixa de texto)
•	Quantidade máxima de alunos (obrigatório, caixa de texto)
•	Enviar (botão de submissão)
Os dados da turma deverão ser cadastrados no BD com o status ATIVA após o clique no botão de submissão. 

Listar Turmas
Ao acessar esta opção, o usuário visualizará uma página contendo todas as turmas cadastradas, ordenadas por nível e horário. As turmas deverão ser exibidas em uma tabela contendo todos os campos utilizados no cadastro da turma. As turmas inativas deverão ser exibidas em linhas vermelhas  o cabeçalho deverá ser diferenciado do resto dos registros.

Alterar/Excluir Turma
Na tabela exibida pela listagem acima, deverá existir um link (em uma imagem) ao final de cada linha, onde o usuário poderá clicar para alterar os dados da turma. Este link só deverá aparecer para as turmas com status “Ativa”. Ao clicar, ele será encaminhado para a mesma tela de cadastro, mas com os valores preenchidos com a turma selecionada e com um campo a mais, um radio com as opções ATIVA (marcado) e INATIVA. Ele poderá efetuar alteração em qualquer campo e submeter o formulário para gravar as modificações no BD. Após isso, ele deverá ser redirecionado para a página de listagem novamente.
Ainda na tabela exibida pela busca, além do ícone para alteração, deverá haver um para exclusão. Caso o usuário clique nele, deverá ser exibida uma mensagem de confirmação da exclusão. Se o usuário confirmar, o registro deverá ser excluído do BD e a listagem atualizada.

Cadastrar Aluno
Ao acessar essa opção, o usuário será encaminhado para uma tela de cadastro de alunos, exibindo os seguintes campos:
•	CPF (obrigatório, caixa de texto)
•	Nome (obrigatório, caixa de texto)
•	Email (obrigatório, caixa de texto)
 Os dados do aluno deverão ser cadastrados no BD após o clique no botão de submissão. 

Matricular Aluno
Nessa opção, o usuário visualizará dois comboboxes preenchidos com dados dos alunos e das turmas existentes no BD. Após selecioná-los e clicar em um botão abaixo dos campos, a matrícula deverá ser efetuada para o aluno na turma em questão. O novo registro deverá ser exibido em uma tabela abaixo dos campos junto com todas as outras matrículas já efetuadas, exibidas em ordem decrescente da data da matrícula. Obs: não é permitido ultrapassar a quantidade máxima de alunos de uma turma. Caso o usuário tente fazer isso, exiba uma mensagem de erro ao usuário.

Buscar Aluno / Registrar Frequência e Nota
Nessa opção, o usuário visualizará uma caixa de texto para informar o código de uma turma. Após inserir o código e tirar o cursor da caixa, deverão ser mostrados, abaixo do campo de busca, uma tabela com os dados dos alunos matriculados (mostrar CPF, nome, email, data matrícula, nota e frequência).
Cada linha da tabela buscada funcionará como um link que, ao ser clicado, exibirá uma blackbox (caixa flutuante modal que se sobrepõe à página exibindo uma área semitransparente preta). A blackbox mostrará dois campos para o usuário registrar a nota e a frequência do aluno na turma. Após o registro, a blackbox deve ser fechada e a janela atrás atualizada.


Persistência em BD

Todos os dados do sistema devem ser persistidos em uma base de dados do SGBD.

Equipe
Formada por no máximo 2 alunos.
	
Entrega
O trabalho deverá ser demonstrado pela equipe na data de entrega. Os membros da equipe serão questionados sobre a implementação do sistema. Alunos da equipe ausentes no dia da apresentação serão penalizados com a perda total de pontos. A entrega do trabalho será na data especificada no plano de ensino.

Atraso
	Os trabalhos só poderão ser entregues no dia da apresentação. Não serão aceitos trabalhos entregues em datas posteriores.

Nota	
A nota do trabalho será de 0 (zero) a 10, sendo parte pela apresentação do trabalho e parte pela avaliação do código. Os alunos serão questionados sobre a implementação do sistema no dia da entrega. O conhecimento de cada aluno sobre a implementação do sistema será usado na atribuição da sua nota de forma que a nota de cada aluno da equipe poderá ser diferente.

Avaliação do trabalho

Serão cobrados no trabalho:
•	Funcionamento adequado segundo descrição do sistema
•	Utilização correta de Java Servlets
•	Acesso ao SGBD via JDBC
•	Utilização correta de orientação a objetos
•	Clareza do código (boa estruturação, comentários, etc)

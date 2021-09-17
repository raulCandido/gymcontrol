## gymcontrol - Modulo de backend


Projeto para atender necessidade de controle geral da academia Vida Ativa, com modulos de suporte e gameficacao para os *alunos* praticantes de **JJ** 

### Stack core da app
- Java
- SpringBoot
- PostgreSQL
### gerar imagem de desenvolvimento
    1° alterar o ip no application.properties, executa ipconfig e coloca o ipv4 
    2° apos fazer as alterações executar o mvn clean package
    3° com o jar gerado vai executar o gerar_image.bat passando o nome da tag da imagem
        ex : gerar_imagem.bat snapshot-1.0
        olhar nas suas images do docker com o comando 
        docker images
    4° alterar o docker-compose.yml no contexto do spring.image: yurialcantara03/gymcontrol:snapshot-1.0
    5° dentro da pasta do projeto executar o comando docker-compose up
    6° acessar localhost:15432/ para acessar a pgadmin4
        usuario : yurialcantara03@gmail.com
        senha : PgAdmin2018!
        clique em server, botão direito -> create 
        General -> name : Local, comments : qualquer coisa
        Connection : Host/name/Address : teste-postgres, port : 5432, maintenance/database, username : postgres, password : Postgres2018!


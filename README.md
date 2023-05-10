# java_customer
repos do projeto microservice customer utilizando java_quarkus

Configuração do projeto Customer
Java 
    -jdk versão 11
    -quarkus versão 2.16.4
Docker
Banco de dados
    -postgres v
Ide
    -intellij

1. Antes de mais nada, precisamos iniciar o banco de dados. para isso precisamos rodar o comando docker abaixo no terminal para o start do container que contem o banco postgres do projeto.

    docker run -p 5436:5432 -e POSTGRES_PASSWORD=1234 postgres
 
2. Como estamos usando um banco configurado em container no docker, precisamos acessar o Dbeaver e criar o DB customerdb conforme o nosso arquivo 
    application.properties.

3. Agora que temos o banco rodando, podemo subir aplicação com o comando maven para iniciar aplicação com jdk normal, acesse o terminal da ide intellij e na pasta do projeto execute o comando abaixo:

    ./mvnw quarkus:dev


3.1 Outra opção é subir aplicação com o Comando para Graalvm 

    mvn clean package -Pnative


3.2 Acessar a pasta target e no terminal digitar o comando para iniciar aplicação

    ./customer-1.0.0-SNAPSHOT-runner


4. Após aplicação finalizar o build e esta com status de started, acessamos o link http://localhost:8080 e temos o swagger no endereço: http://localhost:8080/q/swagger-ui/

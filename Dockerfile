FROM eclipse-temurin:21

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório de trabalho no contêiner
COPY target/APIRastreiosSSW.jar /app/APIRastreiosSSW.jar

# Expõe a porta que a aplicação Spring Boot está rodando
EXPOSE 8881

# Comando para iniciar a aplicação Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "APIRastreiosSSW.jar"]
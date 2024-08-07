 estudar melhor injeção dependencia,
 mantem apenas uma instancia rodando?
 semelhante a static?
 
 static or Bean?
 
 ------
 
injection com private?

injectao por campo ou construtor
 
 ---
 
 @PostMapping(value = "/hello")
public String helloWorld(Locale locale) throws Exception { // testar esse trowhs exceptions

-----
	profiles/properties
	properties com perfil

	
---	
fazer todos endpoints responder com type json etc
----
validation
classe exemplo todas validations
validar UUID com java validation
validation en records

----
relacionamento entidades/eagear leazy
	
-------
	modell maper - testar com entity/record
---
	
	springBoot Actuator
------	

classe todos tipos de dados do postgrees

------

separacao das pacotes por Domain Driven

---
implementacao filtro SQL ,dynamico , where = xxx, order by yyyy


-----
criar formatador do fonte com padroes de nomenclatura java
convensoes nomes java [link](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

criar sonar para avaliar:
- classe sem tostring, equal, hash, etc
- import nao utilizado
---------

//why use response entity, sempre retornar response entity?
	//qual boa pratica pra retornar 
	
--------------
criar context path /api no properties, consigo aplicar filtros dessa forma?

---------------
logger imprimir de qual endpoint originou o log

----
nome de packages, espacos, -??


----
atualizar PDI com filters
-----

testes esta excutand migrations em producao

--------------------
artirfactory

docker run --name artifactory -v $JFROG_HOME/artifactory/var/:/var/opt/jfrog/artifactory -d -p 8081:8081 -p 8082:8082 releases-docker.jfrog.io/jfrog/artifactory-oss:7.77.5

abrir o endereço com o usuario senha = admin/password
http://localhost:8082/ui/

trocar a senha para **Passw0rd**

criar repositorio do tipo maven

criar o arquivo settings, eh possivel baixarr pela UI

configurar o pom com <distributionManagement> Set me Up

é possivel gerar as tags atraves da UI, Application > Artifactory > Artifacts > 
<distributionManagement>
		<repository>
			<id>central</id>
			<name>1826aa60cd9b-releases</name>
			<url>http://localhost:8081/artifactory/libs-release-local</url>
		</repository>
		<snapshotRepository>
			<id>snapshots</id>
			<name>1826aa60cd9b-snapshots</name>
			<url>http://localhost:8081/artifactory/libs-snapshot-local</url>
		</snapshotRepository>
	</distributionManagement>


para o comando release funcionar é necessario possuir a tag populada, so de exisitr o comando ja funciona

<scm>
		<connection>scm:git:git://server_name[:port]/path_to_repository</connection>
</scm>


mvn versions:set -DnewVersion='0.0.3-SNAPSHOT'

mvn --batch-mode --update-snapshots -DreleaseVersion='0.0.3' -DdevelopmentVersion='0.0.3-SNAPSHOT' -DautoVersionSubmodules=true release:clean release:prepare release:perform


	
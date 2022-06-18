all:  clean install spring

spring:
	 mvn -o   -pl webapp/ spring-boot:run
	 
install: 
	 mvn -o -T 1.5C   install

notest:
	mvn -o clean install -DskipTests=true
	 
clean:
	 mvn -o clean -T 1.5C 

	 
all.net: clean install.net  spring.net


install.net: 
	mvn dependency:resolve-plugins dependency:go-offline

	
spring.net:
	mvn dependency:resolve-plugins dependency:go-offline -pl webapp   spring-boot:run

purge:
	rm -rf  ~/.m2/repository/miq/

purge.net:
	mvn dependency:purge-local-repository

eclipse:
	mvn eclipse:eclipse

push :	
	git commit -a
	git push 2> /dev/null


pull : 
	git pull

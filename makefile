all:  clean install spring

spring:
	 mvn -o   -pl webapp/ spring-boot:run
	 
install: 
	 mvn -o -T 1.5C   install

notest:
	mvn -o clean install -DskipTests=true
	 
clean:
	 mvn -o clean -T 1.5C 

net.clean:
	 mvn -o clean -T 1.5C 

	 
net.all: net.clean net.install  net.spring


net.install: 
	mvn dependency:resolve-plugins dependency:go-offline

	
net.spring:
	mvn dependency:resolve-plugins dependency:go-offline -pl webapp   spring-boot:run

purge:
	rm -rf  ~/.m2/repository/miq/

net.purge:
	mvn dependency:purge-local-repository

eclipse:
	mvn eclipse:eclipse

git.push : clean
	git commit -a
	git push 2> /dev/null


git.pull : 
	git pull

git.add : clean
	git add .

git.undo :
	git restore .


# CI
  
* Create a new folder.
* Put your files in this kind of structure
  * jobs(folder)
  * downloads(folder)
  * groovy(folder)
  * Dokerfile
  * plugins.txt
* When it comes to the downloads folder, you have to download
  * apache-maven-3.5.0-bin.tar.gz
  * jdk-7u76-linux-x64.tar
  * jdk-8u131-linux-x64.tar
* In this folder, open terminal and run
  
   ```sudo docker run -p 8080:8080  -v `pwd`/downloads:/var/jenkins_home/downloads -v `pwd`/jobs:/var/jenkins_home/jobs/ -v /var/run/docker.sock:/var/run/docker.sock --rm --name myjenkins myjenkins myjenkins:latest```

* Visit <http://localhost:8080/> you will see all jobs right there

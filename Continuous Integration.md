# Idea

**GitLab**: source code management tool

**Jekins**: trigger to pull, build, dock and push

**Harbor**: place to hold docker image

# How to deploy

## Deploy GitLab

curl https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.rpm.sh

yum install -y gitlab-ce

gitlab-ctl reconfigure

## Deploy Jenkins

tar zxf jdk-8u45-linux-x64.tar.gz

tar zxf apache-maven-3.5.4-bin.tar.gz

mv jdk-8u45-linux-x64 /usr/local/jdk8

mv apache-maven-3.5.4-bin /usr/local/maven

vi /etc/profile

export MAVEN_HOME=/usr/local/maven

export JAVA_HOME=/usr/local/jdk8

export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 

export PATH=$PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin

source /etc/profile

wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war

wget http://mirrors.shu.edu.cn/apache/tomcat/tomcat-8/v8.5.32/bin/apache-tomcat-8.5.32.tar.gz

tar zxf apache-tomcat-8.5.32.tar.gz

mv apache-tomcat-8.5.32 /opt/tomcat-jenkins

rm /opt/tomcat-jenkins/webapps/* -rf

unzip jenkins.war -d /opt/tomcat-jenkins/webapps/ROOT

/opt/tomcat-jenkins/bin/startup.sh

tailf /opt/tomcat-jenkins/logs/catalina.out

## Deploy Docker

yum install -y yum-utils   device-mapper-persistent-data   lvm2

yum-config-manager --add-repo     https://download.docker.com/linux/centos/docker-ce.repo

yum -y install docker-ce

curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://bc437cce.m.daocloud.io

systemctl start docker

systemctl enable docker

cat /etc/docker/daemon.json

{
"registry-mirrors": [ "https://registry.docker-cn.com"],
"insecure-registries":["jackyops.com","192.168.3.16","reg.jackyops.com"]
}

## Deploy Harbor Private Repo

unzip docker-compose-linux-x86_64.zip

cp docker-compose /usr/bin/

chmod +x /usr/bin/docker-compose

tar -xvf harbor-offline-installer-v1.5.1.tgz

cd harbor

vim harbor.cfg

hostname = reg.jackyops.com

./prepare

./install.sh


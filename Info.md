mvn archetype:generate -DgroupId=com.yustunay -DartifactId=yustunayservices -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

--ROOT POM
DependencyManagement -> projects pick what they want from the spring parent pom
Dependencies -> It comes in dependencies of all sub modules

--Add Module
--New Module

docker compose up -d
docker compose ps
docker compose down -v --> also removes volumes


--Run application with program arguments
--server.port=8085



--TROUBLESHOOT
Role XXX not exist : Check 5432 port with using "lsof -i :5432". Probably another postgresdb is running in local machine. Kill the process.


@LoadBalanced on rest template


--List all java versions
/usr/libexec/java_home -V

--Update default java version
vi ~/.bashrc

--Change java version
export JAVA_HOME=$(/usr/libexec/java_home -v17.0.2)

--Reload settings
source ~/.bashrc

mvn clean package -P docker-build-image

--Update cached local images!!!
docker compose pull


docker ps --format=$FORMAT


minikube start
kubectl version --client


kubectl run hello-world \
--image=amigoscode/kubernetes:hello-world \
--port=80

pod/hello-world created

kubectl get pods

kubectl port-forward pod/hello-world 8099:80

kubectl delete pod hello-world

kubectl apply -f bootstrap/postgres

-delete deployments
kubectl delete -f bootstrap/postgres

kubectl get pods -w

kubectl describe pod postgres-0

kubectl logs postgres-0 -f

--to check the mounted volume
minikube ssh
cd \mnt

Ctrl+D -> exit

--CREATE DATABASE INSIDE POSTGRES
kubectl exec -it postgres-0 -- psql -U yustunay

\l
create database customer;
create database fraud;
create database notification;


kubectl get all

--How to reach a service from outside
minikube service --url rabbitmq


kubectl get service zipkin

kubectl get svc

Control + Command + G => Multi select

kubectl scale --replicas=0 deployment customer

--Open LoadBalancer Typed Services To Outside/Localhost
minikube tunnel

CTRL + CMD + SPACE -> Add Emoji


## Build Image
docker build -t portfolio-management-docker:v1 . 

## List Images
docker image list

## List the running container
docker container ls

## List all the containers 
docker container ls -a

## Run docker image as container
docker run -d -p 8080:8080 portfolio-management-docker:v1

## Stop the docker container
docker container stop <container_id>
docker container kill <container_id> - immediately kills the process

## Check docker logs
docker logs <container_id>
docker logs -f <container_id> - to tail the logs

## Change the tag of the image to latest
docker tag <image:0.0.1.RELEASE> <image:latest>

## Pulling an image into local
docker pull <name of image>

## Docker search if image name not known
docker search <name to search>

## Some other useful interesting containers
docker top container <container_id> - gives process running for container
docker events - reports the events of docker
docker stats - all statistics for container

## Interactivity with docker container
docker container exec <name_of_the_container> ls /tmp

## Create spring postgres network
docker network create spring-postgres-network

## Run postgresql container with the network
docker run -d \
  --name postgres-container \
  --network spring-postgres-network \
  -e POSTGRESQL_PASSWORD=1Vd@sawarkar \
  -e POSTGRESQL_USERNAME=postgres \
  -e POSTGRESQL_DATABASE=postgres \
  -p 5433:5432 \
  bitnami/postgresql









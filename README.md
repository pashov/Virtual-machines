# Virtual-machines

To run the project:

- Build the postgre docker image by going to resources/docker-postgre and executing 
`docker build -t pgi .`

- Run the image by executing 
`docker run -d -p 5432:5432 --name pgc -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=pass pgi`

Finally, run App.java


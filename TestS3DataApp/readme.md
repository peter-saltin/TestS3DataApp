Small repository used to test scala and spark with S3

to get started with your fork in linux:
add public key in github ~/.ssh/id_rsa

add following environmental variables:

export AWS_ACCESS_KEY_ID=

export AWS_SECRET_ACCESS_KEY=

stand in folder where you want the repository:
git clone git@github.com:peter-saltin/TestS3DataApp.git

change s3 directory to one of your choosing in /TestS3DataApp/src/SimpleS3DataApp.scala

if you make changes to branch you can stand in repository and use following to update files:
git pull

to build, go to src directory and run:

sbt package

/root/spark/bin/spark-submit --class "SimpleS3DataApp" --master local[4] target/scala-2.10/simple-s3-project_2.10-1.0.jar
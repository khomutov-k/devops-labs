pipeline {
    agent any
     tools {
            maven 'Maven 3.2.5'
            jdk 'jdk-11-windows'
        }
    environment {
        APP_NAME = 'devops-java'
    }

    stages {
        stage ('checkout scm') {
            steps {
                checkout(scm)
            }
        }

        stage ('unit test') {
            steps {
                sh 'echo $JAVA_HOME'
                sh 'cd ./app_java'
                sh 'mvn clean test'
            }
        }

        stage ('build & push') {
            steps {
                sh 'cd ./app_java'
                sh 'mvn -Dmaven.test.skip=true package'
                sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                sh 'docker build -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT .'
            }
        }
    }
}

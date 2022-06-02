pipeline {
    agent any
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
                container ('maven') {
                    sh 'cd ./app_java'
                    sh 'mvn clean test'
                }
            }
        }

        stage ('build & push') {
            steps {
                container ('maven') {
                    sh 'cd ./app_java'
                    sh 'mvn -Dmaven.test.skip=true package'
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker build -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT .'
                }
            }
        }
    }
}

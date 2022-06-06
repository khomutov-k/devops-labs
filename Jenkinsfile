pipeline {
  agent any
  stages {
    stage('checkout scm') {
      parallel {
        stage('checkout scm') {
          steps {
            checkout scm
          }
        }

        stage('') {
          steps {
            sh 'sudo apt install nodejs'
          }
        }

      }
    }

    stage('unit test') {
      steps {
        sh 'echo $JAVA_HOME'
        sh 'mvn clean test -f ./app_java/pom.xml'
      }
    }

    stage('build & push') {
      steps {
        sh 'mvn -Dmaven.test.skip=true package -f ./app_java/pom.xml'
        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
        sh 'docker build -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT .'
      }
    }

  }
  tools {
    maven 'Maven 3.2.5'
  }
  environment {
    APP_NAME = 'devops-java'
  }
}
#!groovy

pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
	  image 'maven:3.5.0'
	}
      }
      steps {
		echo "Before MVN !!!"
        sh 'mvn -f hello/pom.xml clean install'
      }
    }
    stage("SonarQube analysis") {
    agent any
    steps {
     withSonarQubeEnv('SonarQube') {
         sh '/usr/local/maven/bin/mvn -f  hello/pom.xml sonar:sonar'
        }
      }
    }
	stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t sdurgawad/hello:latest .'
      }
    }
	stage ('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
	  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
	  sh 'docker push sdurgawad/hello:latest'
        }
      }
	}
  }
}


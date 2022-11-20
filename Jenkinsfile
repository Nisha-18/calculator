pipeline {
  agent any
  stages {
    stage('Compile') {
      steps{
        sh 'mvn clean compile'
      }
    }

    stage('UnitTest') {
      steps{
        sh 'mvn clean test'
      }
    }
    
    stage('Package') {
      steps{
        sh 'mvn package'
     }
    }
/*
    stage('Deliver') {
      steps{
        deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://18.233.163.71:9090/')], contextPath: null, war: 'target/calculator.war'
     }
    }
    
*/
    stage('Docker Build') {
    	agent any
      steps {
      	sh 'docker build -t pbeniwal/calculatorwithwar:$BUILD_NUMBER .'
      }
    }
    
    stage('Docker Push') {
    	agent any
      steps {
      	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
        	sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push pbeniwal/calculatorwithwar:$BUILD_NUMBER'
        }
      }
    }

  }
}

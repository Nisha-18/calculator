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

    stage('Deliver') {
      steps{
        deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://172.31.87.232:9090/')], contextPath: null, war: 'target/calculator.war'
     }
    }
    
    stage('Docker Build') {
      steps {
        sh 'docker build -t pbeniwal/mycalcwithwar:v$BUILD_NUMBER .'
      }
    }
    
    stage('Docker Push') {
      steps {
      	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
        	sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push pbeniwal/mycalcwithwar:v$BUILD_NUMBER'
        }
      }
    }
    
  }
}

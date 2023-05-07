pipeline {
  agent any
  stages {

    stage('Compile') {
      steps{
        sh 'mvn clean compile'
      }
    }

    stage('Test') {
      steps{
        sh 'mvn clean test'
      }
    }
    
    stage('Package') {
      steps{
        sh 'mvn clean package'
      }
    }
    
    stage('ContDeliver') {
      steps{
        deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://18.213.0.69:9090/calculator/')], contextPath: null, war: 'target/calculator.war'
      }
    }
  }
}

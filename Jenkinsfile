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
    
    stage('Deploy') {
      steps{
         deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://172.31.20.217:9090')], contextPath: null, war: 'target/calculator.war'
       }
    }
  }
}

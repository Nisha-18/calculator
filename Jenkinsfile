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
        sh 'mvn clean package'
      }
    }
    
         stage('Name of my choice') {
      steps{
        sh 'echo Hello'
      }
    }
    
  }
}

pipeline {

  agent any
  stages {
    stage('Compile') {
      steps{
        sh 'mvn clean compile'
      }
    }
    
    stage('Demo') {
      steps{
        sh 'echo Hello'
      }
    }

    stage('Unit Test') {
      steps{
        sh 'mvn clean test'
      }
    }

    stage('Package') {
      steps{
        sh 'mvn clean install'
      }
    }


  }
}

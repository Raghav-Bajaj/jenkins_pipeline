pipeline {
    agent any

    stages {
        stage ('Validate Stage') {
            
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn validate'
                }
            }   
        }      
        
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn test'
                }
            }
        }
        
        options { 
            skipDefaultCheckout() 
        }
         stages{
            stage('Build on Slave'){
               agent {label 'Mavenlabel'}
         steps{
                checkout scm
                sh 'mvn clean install'
           }
        }

        stage ('Package Stage') {
            
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn clean package'
                }
            }
        }
        
        stage ('Verify stage') {
            
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn verify'
                }
            }   
        }
        
        stage ('Installation Stage') {
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn install'
                }
            }
        }    
 
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}

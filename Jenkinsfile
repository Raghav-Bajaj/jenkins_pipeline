pipeline {
    agent {label 'Javalabel'}

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
        
        stage('Build on slave') {
            
            steps {
                withMaven(maven : 'Maven') {
                sh 'mvn clean package'
                }
            }
        }
        
        stage('Building and Integrating Sonar') {
            
            step {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn package sonar:sonar'
                }
            }
        }
        
        stage('Deployment Stage') {
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn install'
                }
            }
        }
    }
}

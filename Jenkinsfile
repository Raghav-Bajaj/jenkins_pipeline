pipeline {
    agent {label 'Javalabel'}

    stages {
        stage ('Validate Stage') {
            
            steps {
                withMaven(maven : 'Apache Maven 7.0.76') {
                    sh 'mvn validate'
                }
            }   
        }      
        
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Apache Maven 7.0.76') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Apache Maven 7.0.76') {
                    sh 'mvn test'
                }
            }
        }
        
        stage('Build on slave') {
            
            steps {
                withMaven(maven : 'Apache Maven 7.0.76') {
                sh 'mvn clean package'
                }
            }
        }
        
        stage('Building and Integrating Sonar') {
            
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn package sonar:sonar'
                }
            }
        }
        
        stage('Deployment Stage') {
            
            steps {
                withMaven(maven : 'Apache Maven 7.0.76') {
                    sh 'mvn install'
                }
            }
        }
    }
}

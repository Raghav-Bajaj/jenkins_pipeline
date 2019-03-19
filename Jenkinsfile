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
        
        stage ('Deploy to Tomcat') {
       
            steps {
                sshagent (credentials: ['tomcat']) {
                    sh 'scp -o StrictHostKeyChecking=no /home/ec2-user/jenkinsbuild/workspace/myPipelineJob/target/*.jar ec2-user@//13.233.142.28:/opt/tomcat/webapps/'
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
                withMaven(maven : 'Maven') {
                    sh 'mvn install'
                }
            }
        }
    }
}

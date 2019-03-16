pipeline {
    agent any

    stages {
        stage ('Validate Satge') {
            
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
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn install'
                }
            }
        }
    }
}

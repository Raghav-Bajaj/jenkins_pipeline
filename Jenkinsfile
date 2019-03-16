pipeline {
    agent any

    stages {
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
        
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'Maven') {
                    sh 'mvn install'
                }
            }
        }
    }
}

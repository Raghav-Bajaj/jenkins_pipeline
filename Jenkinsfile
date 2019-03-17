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
        
        node (label 'Mavenlabel') {
            stage ('Build') {
                    echo "Building.."
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

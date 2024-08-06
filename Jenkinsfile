pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'

                sh 'mvn package'
            }
        }
        stage('JUnit Test') {
            steps {
                sh 'mvn test'

                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
    post {
        
        failure {
            mail to: 'supriyaveeramally@gmail.com',
                 subject: 'Build failed: ${JOB_NAME} #${BUILD_NUMBER}',
                 body: 'Check the console output for details.'
        }
    }
}

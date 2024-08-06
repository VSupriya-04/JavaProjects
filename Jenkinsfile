pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'

                sh 'mvn package'
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

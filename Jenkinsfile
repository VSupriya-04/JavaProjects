pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Pre-build') {
            steps {
                sh 'mvn clean validate'
                sh 'mvn checkstyle:checkstyle'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Email Notification') {
            steps {
                mail to: 'supriyaveeramally@gmail.com',
                     subject: 'Build ${BUILD_NUMBER} ${BUILD_STATUS}',
                     body: 'Check the build logs for details.',
                     attachmentsPattern: '**/*.log'
            }
        }
    }
}

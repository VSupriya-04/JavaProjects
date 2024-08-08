pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Clean Stage') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Test Stage') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    jacocoReport aggregateSourceCodeCoverage()
                }
            }
        }
        stage('Build Stage') {
            steps {
                echo 'Build Success!'
            }
        }
        stage('JUnit Test') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('SonarCloud Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    sh 'mvn sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=<VSupriya-04> -Dsonar.password=<f1d037f54aee2e06cbd01225f8cf8c687bcf3c65> -Dsonar.projectKey=<vsupriya-04> -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml'
                }
            }
        }
    }

    post {
        always {
            sonarQualityGate()
        }
        success {
            emailext (
                to: 'supriyaveeramally@gmail.com',
                subject: 'Build ${BUILD_NUMBER} ${BUILD_STATUS}',
                body: 'Check the build logs for details.',
                attachmentsPattern: '**/*.log'
            )
        }
        failure {
            emailext (
                to: 'supriyaveeramally@gmail.com',
                subject: 'Build ${BUILD_NUMBER} ${BUILD_STATUS}',
                body: 'Check the build logs for details.',
                attachmentsPattern: '**/*.log'
            )
        }
    }
}

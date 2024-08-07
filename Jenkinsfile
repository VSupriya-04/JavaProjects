pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }
    stages {
        stage('Clean Stage') {
            steps {
                bat 'mvn clean'
                sh 'python clean_extra.py'
            }
        }
        stage('Test Stage') {
            steps {
                bat 'mvn test'
                sh './test_extra.sh'
            }
        }
        stage('Build Stage') {
            steps {
                echo 'Build Success!'
                python {
                    script {
                        println "Running additional build tasks..."
                    }
                }
            }
        }
        stage('JUnit Test') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                sh './junit_extra.sh'
            }
        }
        stage('GATE - Quality Gate') {
            steps {
                python {
                    script {
                        println "Running quality gate checks..."
                    }
                }
                sh './quality_gate_extra.sh'
                gate {
                    condition {
                        // Check if the quality gate checks passed
                        // ...
                    }
                    failure {
                        emailext (
                            to: 'supriyaveeramally@gmail.com',
                            subject: 'Quality Gate Failure - Build ${BUILD_NUMBER} ${BUILD_STATUS}',
                            body: 'Check the build logs for details.',
                            attachmentsPattern: '**/*.log'
                        )
                    }
                }
            }
        }
    }
    post {
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

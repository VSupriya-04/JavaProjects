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
                stage ('Test Stage') {
                  steps {
                            bat 'mvn test'
                        }
                }
                stage ('Build Stage') {
                  steps {
                            echo 'Build Success!'
                        }
                }
                stage('JUnit Test') {
                  steps {
                          junit '**/target/surefire-reports/*.xml'
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
}

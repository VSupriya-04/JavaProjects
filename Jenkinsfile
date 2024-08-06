pipeline {
agent any
           tools {
                        maven 'MAVEN_HOME'
                 }
          stages {
                stage('Stage 1: Hello Clean Stage 1') {
                   steps {
                             bat 'mvn clean'
                          }
                }
                stage ('Stage 2: Test Stage') {
                  steps {
                            bat 'mvn test'
                        }
                }
                stage ('Stage 3: My Package') {
                  steps {
                             bat 'mvn package'
                        }
                }
                stage ('Stage 4: My Final Build Stage') {
                  steps {
                           bat 'mvn install'
                       }
                }
                stage ('Stage Final: Build Success') {
                  steps {
                            echo 'Build Success!'
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


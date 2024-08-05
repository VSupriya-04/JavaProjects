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
                post{
                  always{
                      emailtext{
                           subject: "Pipeline Status: ${BUILD_NUMBER}"
                           body: '''<html>
                                        <body>
                                            <p>Build Status: ${BUILD_STATUS}</p>
                                            <p>Build Number: ${BUILD_NUMBER}</p>
                                            <p>Check the <a href= "${BUILD_URL}">Console output</a></p>
                                         </body>
                                     </html>''',
                           to: "supriyaveeramally@gmail.com",
                           from: "jenkins@example.com",
                           mimeType: 'text/html'
                      }
                  }
                }
       }
}

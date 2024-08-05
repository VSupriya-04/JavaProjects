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
                           subject: "Pipeline Status: $(currentBuild.result)"
                           body: '''<html>
                                        <body>
                                            <p>Build Status: $(currentBuild.result)</p>
                                            <p>Build Number: $(currentBuild.number)</p>
                                            <p>Check the <a href= "$(env_BUILD_URL)">Console output</a></p>
                                         </body>
                                     </html>''',
                           to: "supriyaveeramally@gmail.com",
                           from: "jenkins@example.com",
                           replyTo: "jenkins@example.com",
                           mimeType: 'text/html'
                      }
                  }
                }
       }
}

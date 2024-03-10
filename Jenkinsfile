CODE_CHANGES= getGitChanges()
pipeline {
    agent any
    environment {
        NEW_VERSION='1.3.0'
        // SERVER_CREDENTIALS = credentials('jenkins-credentials')
    }
    tools {
        // maven 'maven' 
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
        string(name: 'NAME', defaultValue: 'test', description: '')
        text(name: 'DESCRIPTION', defaultValue: 'test', description: '')


    }
    
    stages {
        stage('build') {
              when:{
                expression {
                    BRANCH_NAME == 'dev' && CODE_CHANGES == true
                }

            },
            steps {
                echo 'building the application'
                echo "building the application version ${NEW_VERSION}" 
            }
        }
        stage('test') {
            when:{
                expression {
                    BRANCH_NAME == 'dev' && params.executeTests == true
                }

            },
            steps {
                echo 'testing'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application '
                echo "deploying the application version ${params.VERSION}"
                withCredentials([usernamePassword(credentialsId: 'server-test-credentials',
                 usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'echo ${USERNAME} ${PASSWORD}'
                }
            }
        }
    }
    post:{
        always{
            echo 'this will always run'
        }
        success{
            echo 'this will run only if successful'
        }
        failure{
            echo 'this will run only if failed'
        }
    }
}
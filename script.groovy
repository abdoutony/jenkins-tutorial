def buildApp(){
    echo "Building the application ..."
}

def deployApp(){
        echo 'Deploying the application '
        echo "Deploying the application version ${params.VERSION}"
        withCredentials([usernamePassword(credentialsId: 'server-test-credentials',
            usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            sh 'echo ${USERNAME} ${PASSWORD}'
        }
}

def testApp(){
    echo "Testing the application ..."
}

return this
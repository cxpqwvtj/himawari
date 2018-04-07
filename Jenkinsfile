pipeline {
    agent none
    options {
        buildDiscarder(logRotator(numToKeepStr: '0', artifactNumToKeepStr: '5'))
    }
    stages {
        stage('checkout') {
            agent node: master
            steps {
                deleteDir()
                checkout scm
                stash name: project
            }
        }
    }
}

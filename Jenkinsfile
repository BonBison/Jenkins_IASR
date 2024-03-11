pipeline {
    agent {
        docker {
            image 'openjdk:17'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    dir('src') {
                        sh 'javac Main.java Dinosaur.java'
                        sh 'jar cvfe dinosaurs.jar Main *.class'
                    }
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: 'src/dinosaurs.jar', onlyIfSuccessful: true
                }
            }
        }
    }
}

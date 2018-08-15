pipeline {
    agent { docker { image 'openjdk:8-jdk-alpine' } }
    stages {
        stage('build') {
            steps {
                sh './gradlew build --no-daemon'
            }
        }
        stage('test') {
            steps {
                sh './gradlew test --no-daemon'
            }
        }
        stage('build docker image') {
            steps {
                sh 'docker build . -t prodtrak'
            }
        }
    }
}
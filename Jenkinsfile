pipeline {
    agent none
    stages {
        stage('build') {
            agent { docker { image 'openjdk:8-jdk-alpine' }}
            steps {
                sh './gradlew build --no-daemon'
            }
        }
        stage('test') {
            agent { docker { image 'openjdk:8-jdk-alpine' }}
            steps {
                sh './gradlew test --no-daemon'
            }
        }
        stage('build docker image') {
            agent any
            steps {
                sh 'docker build . -t prodtrak'
            }
        }
    }
}
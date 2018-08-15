pipeline {
    agent none
    stages {
        stage('build') {
            agent { docker { image 'openjdk:8-jdk-alpine' }}
            steps {
                sh './gradlew build --no-daemon'
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
                stash includes: '**/build/libs/*.jar', name: 'jar'
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
                unstash 'jar'
                sh 'docker build . -t prodtrak'
            }
        }
    }
}
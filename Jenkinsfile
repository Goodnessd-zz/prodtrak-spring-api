pipeline {
    agent none
    stages {
        stage('build') {
            steps {
                agent { docker { image 'openjdk:8-jdk-alpine' }}
                sh './gradlew build --no-daemon'
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
                stash includes: 'demo.jar', name: 'jar'
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
                copyArtifacts(
                        projectName: 'prodtrak-spring-api',
                        filter: '**/*.jar',

                )
                sh 'docker build . -t prodtrak'
            }
        }
    }
}
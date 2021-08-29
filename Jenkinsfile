pipeline {
    options {
        disableConcurrentBuilds()
    }
    agent {
        kubernetes {
            label 'docker-in-docker-maven'
            yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3-adoptopenjdk-11-openj9
    command: ['cat']
    tty: true
    env:
      - name: DOCKER_HOST
        value: tcp://localhost:2375
  - name: docker-client
    image: docker:19.03.1
    command: ['sleep', '99d']
    env:
      - name: DOCKER_HOST
        value: tcp://localhost:2375
  - name: docker-daemon
    image: docker:19.03.1-dind
    env:
      - name: DOCKER_TLS_CERTDIR
        value: ""
    securityContext:
      privileged: true
    volumeMounts:
        - name: cache
          mountPath: /var/lib/docker
  volumes:
    - name: cache
      hostPath:
        path: /tmp
        type: Directory
"""
        }
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/joostvdg/mnaut-demo.git'
            }
        }
        stage('Maven Build') {
            steps {
                container('maven') {
                    sh 'mvn test'
                }
            }
        }
    }
}
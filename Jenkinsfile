pipeline {
    agent any
    tools {
        jdk 'jdk21'
        gradle 'gradle'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    checkout scm
                    sh './gradlew clean build'
                }
            }
        }

        stage('Dependency Submission') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                script {
                    sh './gradlew dependencyUpdates'
                }
            }
        }

        stage('Approval') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                script {
                    def approvers = ['gebozhinov']
                    def approval = input(
                        message: "PR requires developer approval",
                        ok: "Submit",
                        parameters: [
                            choice(
                                name: 'Approvers',
                                choices: approvers.join('\n'),
                                description: 'Select approving senior developer'
                            )
                        ]
                    )
                    echo "Approved by: ${approval}"
                }
            }
        }
    }
}

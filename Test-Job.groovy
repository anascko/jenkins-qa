#!/usr/bin/groovy
 
/**
    Test jenkins Job
    
    def PROJECT_URL="https://github.com/tldr-pages/tldr"
    def PROJECT="tldr"
    def BRANCH="master"
    
*/

node('builder') {    
    stage('Get repository and install project') {
        return sh (script: """
        set -xe
        git clone ${PROJECT_URL} -b ${BRANCH}
        cd ${PROJECT}
        npm install
        """, returnStdout: true)
    }

if (RUN_TEST.toBoolean()){
    stage('Run test') {
        def result = sh (
            script: 'tldr -V',
            returnStdout: true
        ).trim()
    
    }
}
}

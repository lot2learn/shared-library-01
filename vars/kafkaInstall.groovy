#!/usr/bin/env groovy

def ansibleDeploy(String deploymentType, String hostFile, String mainPlaybook) {
    if (deploymentType == "all") {
        def command = 'ansible-playbook -i ' + hostFile + ' ' + mainPlaybook
        sh command
    }
}

def getCurrDir() {
    sh 'pwd'
}

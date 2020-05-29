#!/usr/bin/env groovy

def call(String deploymentType, String hostFile, String mainPlaybook) {
    if (deploymentType == "all") {
        def command = 'ansible-playbook -i ' + hostFile + ' ' + deploymentType + ' ' + mainPlaybook
        def proc = command.execute()
        proc.waitFor()

        println "Std Out: ${proc.in.text}"
    }
}
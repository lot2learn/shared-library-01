#!/usr/bin/env groovy

def call(String deploymentType, String hostFile, String mainPlaybook) {
    if (deploymentType == "all") {
        def command = 'ansible-playbook -i ' + hostFile + ' ' + deploymentType + ' ' + mainPlaybook
        println command
        def proc = command.execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitFor()
        println "Std Out: ${proc.in.text}"
        return sout.tokenize()
    }
}

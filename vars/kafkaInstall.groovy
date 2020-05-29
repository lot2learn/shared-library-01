#!/usr/bin/env groovy

def ansibleDeploy(String deploymentType, String hostFile, String mainPlaybook) {
    if (deploymentType == "all") {
        def sout = new StringBuffer(), serr = new StringBuffer()
        // def command = 'pwd && ls'
        def command = 'ansible-playbook -i ' + hostFile + ' ' + mainPlaybook
        println command
        def proc = command.execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitFor()
        println "Std Out: ${proc.in.text}"
        println serr.tokenize()
        return sout.tokenize()
    }
}

def getCurrDir() {
    def sout = new StringBuffer(), serr = new StringBuffer()
    def cmd = "pwd"
    def proc = cmd.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitFor()
    println "Std Out: ${proc.in.text}"
    println serr.tokenize()
    return sout.tokenize()
}

#!/usr/bin/env groovy

def call(String deploymentType, String hostFile, String mainPlaybook) {
    def cmd = "pwd"
    def proc = cmd.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitFor()
    println "Std Out: ${proc.in.text}"
    println serr.tokenize()
    return sout.tokenize()
}
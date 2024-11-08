// Create Freestyle Job
job('Freestyle_Job') {
    description('A simple Freestyle Job that pulls code from GitHub and prints a welcome message.')
    
    steps {
        shell('echo "Welcome to the Freestyle Job!"')
    }
}

// Create Pipeline Job
pipelineJob('Pipeline_Job') {
    description('A basic Pipeline Job that demonstrates a simple scripted pipeline.')
    
    definition {
        cps {
            script("""
                pipeline {
                    agent any
                    stages {
                        stage('Welcome') {
                            steps {
                                echo 'Welcome to the Pipeline Job!'
                            }
                        }
                    }
                }
            """.stripIndent())
        }
    }
}

// Create Multi-Branch Pipeline Job
multibranchPipelineJob('MultiBranch_Pipeline_Job') {
    description('A Multi-Branch Pipeline Job that scans the GitHub repository for branches and builds each branch.')

    branchSources {
        git {
            id('123456789') // Unique identifier for this branch source
            remote('\${GIT_URL}')
        }
    }

    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile') // This could be used if Jenkinsfiles are added in the future
        }
    }
}

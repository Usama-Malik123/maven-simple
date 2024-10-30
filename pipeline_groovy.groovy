// Define a function to create a pipeline for each branch
def createPipeline(branchName, scriptName) {
    job("pipeline-${branchName}") {
        description("Pipeline for ${branchName} branch.")

        scm {
            git("https://github.com/Usama-Malik123/maven-simple.git") {
                branch(branchName)
            }
        }

        triggers {
            cron('H * * * *') // Optional: Run every minute
        }

        steps {
            groovyCommand(scriptName) // Execute the specific script for the branch
        }
    }
}

// Create pipelines for each branch with their respective scripts
createPipeline('master', 'demo')
createPipeline('feature', 'test')
createPipeline('feature1', 'test1')
createPipeline('feature2', 'test2')


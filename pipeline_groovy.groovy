// Define a function to create a pipeline for each branch
def createPipeline(branchName, fileName) {
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
            shell("echo 'Running ${fileName} in ${branchName} branch'")
            // You can add additional steps to execute the specific files here
        }
    }
}

// Create pipelines for each branch
createPipeline('master', 'demo')
createPipeline('feature', 'test')
createPipeline('feature1', 'test1')
createPipeline('feature2', 'test2')


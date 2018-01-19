# pipeline-library
This repository serves as a location for a starting point for Jenkins pipelines and shared libraries. There is a pipeline template for a Maven application and a Nodejs application.

## Jenkinsfiles and Pipelines



agent - Specifies jenkins slave node where you want to run the jobs. Can be defined per Stage as well.

tools - Specify global tool configurations.
stages - Defines different phases of a Pipeline. For eg. Build/CodeQuality/Deploy/Test.
steps - These are the steps defined within a stage. This could be a shared library call or specific executions depending on the available plugins.

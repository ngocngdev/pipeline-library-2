/*
 * This is a shared library function intended to be used during the code analysis stage
 * of a pipeline. Code analysis might differ depending on the application. 
 *
 * @param buildType specifies the type of application.
 */

def call(String buildType) {
  if (buildType == "maven"){
    /*
     * sh '/opt/sonar-runner-2.4/bin/sonar-runner'
     */
  }
  else if (buildType == "nodejs"){
    /*
     * sh '/opt/sonar-runner-2.4/bin/sonar-runner'
     */
  }
}


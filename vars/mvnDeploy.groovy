/*
 * Deploys a maven project.
 *
 */

def call() {
  configFileProvider(
  [configFile(fileId: 'nexus', variable: 'MAVEN_SETTINGS')]) {
    sh "mvn -s $MAVEN_SETTINGS deploy -DskipTests=true -B"
  }
}

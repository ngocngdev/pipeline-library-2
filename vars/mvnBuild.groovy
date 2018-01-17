/*
 * Builds a maven project.
 *
 */

def call() {
  sh "mvn clean validate -DskipTests=true -B"
}

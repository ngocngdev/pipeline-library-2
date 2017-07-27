package org.springframekwork;

class Utilities implements Serializable {
  def steps
  Utilities(steps) {this.steps = steps}
  def DeployToDev(String project, String args) {
    steps.sh 'docker rm -f dev-${project} || true'
    steps.sh 'docker run -p 18888:8080 -d --network=${LDOP_NETWORK_NAME} --name dev-${project} ${args}'
  }
}
def SmokeTestDev(String project) {
   agent {
     docker {
       image 'maven:3.5.0'
       args '--network=${LDOP_NETWORK_NAME}'
      }
    }
      steps.sh "cd regression-suite"
      steps.sh "mvn clean -B test -DPETCLINIC_URL=http://dev-${project}:8080/${project}/"
      echo "Should be accessible at http://localhost:18888/${project}"
}
def DeployToQA(String project) {
   agent any
    steps.sh 'docker rm -f qa-${project} || true'
    steps.sh 'docker run -p 18889:8080 -d --network=${LDOP_NETWORK_NAME} --name qa-${project} ${project}-tomcat'
}
def SmokeTestQA(String project) {
   agent {
     docker {
       image 'maven:3.5.0'
       args '--network=${LDOP_NETWORK_NAME}'
     }
   }
      steps.sh "cd regression-suite"
      steps.sh "mvn clean -B test -DPETCLINIC_URL=http://qa-${project}:8080/${project}/"
      echo "Should be accessible at http://localhost:18889/${project}"
      input 'Deploy to Prod?'
}
def DeployToProd(String project) {
   agent any
     steps.sh 'docker rm -f prod-${project} || true'
     steps.sh 'docker run -p 18890:8080 -d --network=${LDOP_NETWORK_NAME} --name prod-${project} ${project}-tomcat'
}
def SmokeTestProd(String project) {
   agent {
      docker {
        image 'maven:3.5.0'
        args '--network=${LDOP_NETWORK_NAME}'
      }
   }
      steps.sh "cd regression-suite"
      steps.sh "mvn clean -B test -DPETCLINIC_URL=http://prod-${project}:8080/${project}/"
      echo "Should be accessible at http://localhost:18890/${project}"
}

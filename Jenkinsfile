node{
  stage('SCM Checkout'){
    git 'https://github.com/MicroJava-Pradeep/project'
  }
  stage('Compile-Package'){
    // get maven package
    def mvnHOME = tool name: 'C:\\Program Files\\Maven\\apache-maven-3.2.2-bin\\apache-maven-3.2.2\\bin', type: 'maven'
    sh "${mvnHOME}/bin/mvn package"
  }
}

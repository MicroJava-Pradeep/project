node{
  stage('SCM Checkout'){
    git 'https://github.com/MicroJava-Pradeep/project'
  }
  stage('Compile-Package'){
    // get maven package
    def M2_HOME = tool 'Default'
    sh "${mvnHOME}/bin/mvn package"
  }
}

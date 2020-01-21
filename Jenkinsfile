node{
  stage('SCM Checkout'){
    git 'https://github.com/MicroJava-Pradeep/project'
  }
  stage('Compile-Package'){
    // get maven package
    def mvnHOME = tool 'Default'
    sh "${mvnHOME}/bin/mvn package"
  }
}

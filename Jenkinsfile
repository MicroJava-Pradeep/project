node{
  stage('SCM Checkout'){
    git 'https://github.com/MicroJava-Pradeep/project.git'
  }
  stage('Compile-Package'){
    // get maven package
    def mvnHOME = tool name: '', type: 'maven'
    sh "${mvnHOME}/bin/mvn package"
  }
}

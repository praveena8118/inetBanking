pipeline{
agent any
stages{
  stage("gitpull"){
  step{
    echo 'pull code from git...'
  }
  }
  stage("build"){
  step{
   echo 'build of code..'
  }
  }
  stage("testanddeploy"){
  step{
  echo 'putest and deploy....'
  }
  }
}

}

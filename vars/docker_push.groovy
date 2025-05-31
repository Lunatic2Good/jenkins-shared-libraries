def call(String Project, String ImageTag) {
  echo 'This is pushing the image to DockerHub'
  withCredentials([usernamePassword(
      'credentialsId': "dockerHubCred",
      passwordVariable: "dockerHubPass",
      usernameVariable: "dockerHubUser")]) {
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
      // sh "docker image tag ${Project}:${ImageTag} ${env.dockerHubUser}/${Project}:${ImageTag}" we doing this in build itself
      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
  }
}

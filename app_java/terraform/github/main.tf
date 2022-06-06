terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = ">= 2.13.0"
    }
  }
}
provider "docker" {
  host = "npipe:////.//pipe//docker_engine"
}

resource "docker_image" "devops-labs" {
  name = "konstantinkhomutov/devops-labs:latest"
}

resource "docker_container" "devops-labs-container" {
  image = docker_image.devops-labs.latest
  name  = "java-app"
  ports {
    internal = 8080
    external = 8080
  }
}
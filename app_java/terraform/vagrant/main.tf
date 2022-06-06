terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = ">= 2.13.0"
    }
    vagrant = {
      source  = "bmatcuk/vagrant"
      version = ">= 4.0.0"
    }
  }
}
provider "vagrant" {}

provider "docker" {
  host = "npipe:////.//pipe//docker_engine"
}

resource "vagrant_vm" "my_vagrant_vm" {
  name      = "vagrantbox"
  get_ports = true
}

#resource "docker_image" "devops-labs" {
#  name = "konstantinkhomutov/devops-labs:latest"
#}
#
#resource "docker_container" "devops-labs-container" {
#  image = docker_image.devops-labs.latest
#  name  = "java-app"
#  ports {
#    internal = 8080
#    external = 8080
#  }
#}

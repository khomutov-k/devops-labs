terraform {
  required_providers {
    github = {
      source  = "integrations/github"
      version = ">= 4.0"
    }
  }
}
provider "github" {
}

resource "github_repository" "Devops" {
  name        = "devops-labs-1"
  description = "Solutions to DevOps labs"

  visibility = "public"

  auto_init = true
}
  resource "github_branch" "development" {
    repository = github_repository.Devops.name
    branch     = "dev"
  }

  resource "github_branch_default" "default"{
    repository = github_repository.Devops.name
    branch     = github_branch.development.branch
  }
resource "github_branch_protection_v3" "example" {
  repository     = github_repository.Devops.name
  branch         = "dev"

  restrictions {
    users = ["devops-labs-KK"]
  }
}
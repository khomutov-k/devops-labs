resource "github_repository" "devops-labs" {
  name = "devops-labs"
}

resource "github_branch" "lab-4-tf-branch" {
  repository = github_repository.devops-labs.name
  branch     = "lab-4-tf-branch"
  source_branch = "master"
}
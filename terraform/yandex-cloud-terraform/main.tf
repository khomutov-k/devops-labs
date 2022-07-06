terraform {
  required_providers {
    yandex = {
      source = "yandex-cloud/yandex"
    }
  }
  required_version = ">= 0.75"
}

provider "yandex" {
  zone  = "ru-central1-a"
  token = var.YC_TOKEN
  folder_id = var.YC_FOLDER_ID
  cloud_id = var.YC_CLOUD_ID
}

variable "YC_TOKEN" {
  type = string
}

variable "YC_FOLDER_ID" {
  type = string
}

variable "YC_CLOUD_ID" {
  type = string
}


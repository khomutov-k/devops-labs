resource "yandex_compute_instance" "default" {
  name        = "devops-lab-vm"
  platform_id = "standard-v2"
  zone        = "ru-central1-a"

  resources {
    cores         = 2
    memory        = 1
    core_fraction = 5
  }

  boot_disk {
    initialize_params {
      image_id = "fd8h34rub6pjpg4qgi8j"
    }
  }

  network_interface {
    subnet_id = yandex_vpc_subnet.devops.id
    nat       = true
  }

  metadata = {
    ssh-keys = "ubuntu:${file("~/.ssh/dev2.pub")}"
  }

  scheduling_policy {
    preemptible = true
  }
}

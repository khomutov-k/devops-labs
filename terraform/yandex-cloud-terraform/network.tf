resource "yandex_vpc_network" "default" {
  name = "devops"
}

resource "yandex_vpc_subnet" "devops" {
  network_id     = yandex_vpc_network.default.id
  v4_cidr_blocks = ["10.128.0.0/24"]
}
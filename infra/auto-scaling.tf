variable "access_key" {}
variable "secret_key" {}

provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region     = "us-west-2"
}

resource "aws_launch_configuration" "lc-aws-study-group" {
  name_prefix   = "aws-study-group-"
  image_id      = "ami-f37a758a"
  instance_type = "t2.nano"
  user_data     = "java -jar aws-study-group-0.0.1-SNAPSHOT.jar"

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_autoscaling_group" "asg-aws-study-group" {
  name                 = "aws-study-group"
  launch_configuration = "${aws_launch_configuration.lc-aws-study-group.name}"
  min_size             = 1
  max_size             = 5

  lifecycle {
    create_before_destroy = true
  }
}
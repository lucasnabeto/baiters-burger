terraform {
  backend "s3" {
    bucket = "terraform-state-baitersburguer"
    key    = "infra/terraform.tfstate"
    region = "us-east-1"
  }

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.31.0"
    }
  }
}

provider "aws" {
  region  = "us-east-1"
}
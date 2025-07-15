terraform {
  backend "s3" {
    bucket = "s3-baitersburger-academy"
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
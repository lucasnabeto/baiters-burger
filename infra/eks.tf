# Bloco de Data Source para buscar a VPC existente
data "aws_vpc" "existing" {
  filter {
    name   = "state"
    values = ["available"]
  }
}

# Procura as sub-redes que pertencem a essa VPC, mas filtra pelas AZs suportadas.
data "aws_subnets" "filtered_for_eks" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.existing.id]
  }

  # Seleciona apenas sub-redes nas AZs que o EKS suporta
  filter {
    name   = "availability-zone"
    values = ["us-east-1a", "us-east-1b", "us-east-1c", "us-east-1d", "us-east-1f"]
  }
}

 # Utiliza a role LabRole pq não podemos criar novas roles no aws academy
data "aws_iam_role" "eks_cluster_role" {
  name = "LabRole"
}

# Cria o cluster EKS
resource "aws_eks_cluster" "baitersburger_cluster" {
  name     = "baitersburger-cluster"
  version  = "1.28"
  role_arn = data.aws_iam_role.eks_cluster_role.arn

  vpc_config {
    # Usa a lista de sub-redes filtradas.
    subnet_ids = data.aws_subnets.filtered_for_eks.ids
  }
}

resource "aws_eks_node_group" "worker_nodes" {
  cluster_name    = aws_eks_cluster.baitersburger_cluster.name
  node_group_name = "app-worker-nodes"
  node_role_arn   = data.aws_iam_role.eks_cluster_role.arn
  subnet_ids      = data.aws_subnets.filtered_for_eks.ids

  instance_types = ["t2.medium"]
  scaling_config {
    desired_size = 1
    min_size     = 1
    max_size     = 2
  }

  depends_on = [aws_eks_cluster.baitersburger_cluster]
}

output "kubeconfig_command" {
  description = "Comando para configurar o kubectl para este cluster."
  value       = "aws eks update-kubeconfig --region us-east-1 --name ${aws_eks_cluster.baitersburger_cluster.name}"
}
helm upgrade --install mnaut-demo charts/mnaut-demo --set image.tag=0.1 --set ingress.k3d.enabled=true
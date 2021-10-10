## CONFIG LOCAL ENV
echo "[*] Config local environment..."
#alias vault='docker-compose exec vault vault "$@"'

vault()
{
	docker-compose exec vault vault "$@"
}
export -f vault

export VAULT_ADDR=http://127.0.0.1:8200

## UNSEAL VAULT
echo "[*] Unseal vault..."
#vault unseal -address=${VAULT_ADDR} $(grep 'Key 1:' ./data/keys.txt | awk '{print $NF}')
#vault unseal -address=${VAULT_ADDR} $(grep 'Key 2:' ./data/keys.txt | awk '{print $NF}')
#vault unseal -address=${VAULT_ADDR} $(grep 'Key 3:' ./data/keys.txt | awk '{print $NF}')

KEY=$(grep 'Key 1:' ./data/keys.txt | awk '{print substr($NF,0,44)}')
vault operator unseal ${KEY}
KEY=$(grep 'Key 3:' ./data/keys.txt | awk '{print substr($NF,0,44)}')
vault operator unseal ${KEY}
KEY=$(grep 'Key 5:' ./data/keys.txt | awk '{print substr($NF,0,44)}')
vault operator unseal ${KEY}

param(
    [string]$ResourceGroupName
)

# Connect to Azure
Connect-AzAccount

# Example command using the parameter
Get-AzResourceGroup -Name $ResourceGroupName

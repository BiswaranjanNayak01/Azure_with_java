param (
    [string]$Host = $global:DefaultHost,
    [string]$Token = $global:DefaultToken
)

$headers = @{
    Authorization = "Bearer $Token"
    "Content-Type" = "application/json"
}

$runId = Get-Content run_id.txt
$response = Invoke-RestMethod -Method GET "$Host/api/2.1/jobs/runs/get-output?run_id=$runId" -Headers $headers

if ($response.notebook_output) {
    Write-Host "`n📋 Output:"
    $response.notebook_output.result
} else {
    Write-Host "❌ No output found."
}

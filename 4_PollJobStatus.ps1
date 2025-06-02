param (
    [string]$Host = $global:DefaultHost,
    [string]$Token = $global:DefaultToken
)

$headers = @{
    Authorization = "Bearer $Token"
    "Content-Type" = "application/json"
}

$runId = Get-Content run_id.txt

do {
    Start-Sleep -Seconds 5
    $status = Invoke-RestMethod -Method GET "$Host/api/2.1/jobs/runs/get?run_id=$runId" -Headers $headers
    $state = $status.state.life_cycle_state
    Write-Host "⏳ Status: $state"
} while ($state -ne "TERMINATED")

Write-Host "✅ Job completed"

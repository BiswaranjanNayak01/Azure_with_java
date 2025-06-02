param (
    [string]$Host = $global:DefaultHost,
    [string]$Token = $global:DefaultToken
)

$headers = @{
    Authorization = "Bearer $Token"
    "Content-Type" = "application/json"
}

$jobId = Get-Content job_id.txt
$body = @{ job_id = [int]$jobId } | ConvertTo-Json

$response = Invoke-RestMethod -Method POST "$Host/api/2.1/jobs/run-now" -Headers $headers -Body $body
$response.run_id | Out-File run_id.txt -Encoding ascii
Write-Host "▶️ Job started: $($response.run_id)"

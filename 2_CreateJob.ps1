param (
    [string]$Host = $global:DefaultHost,
    [string]$Token = $global:DefaultToken,
    [string]$ClusterId = $global:DefaultClusterId,
    [string]$NotebookPath = $global:DefaultNotebookPath,
    [string]$JobName = $global:DefaultJobName
)

$headers = @{
    Authorization = "Bearer $Token"
    "Content-Type" = "application/json"
}

$body = @{
    name = $JobName
    existing_cluster_id = $ClusterId
    notebook_task = @{
        notebook_path = $NotebookPath
    }
} | ConvertTo-Json -Depth 3

$response = Invoke-RestMethod -Method POST "$Host/api/2.1/jobs/create" -Headers $headers -Body $body
$response.job_id | Out-File job_id.txt -Encoding ascii
Write-Host "✅ Job created: $($response.job_id)"

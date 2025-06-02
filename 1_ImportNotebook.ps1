param (
    [string]$Host = $global:DefaultHost,
    [string]$Token = $global:DefaultToken,
    [string]$NotebookPath = $global:DefaultNotebookPath,
    [string]$SqlQuery = "SELECT * FROM demo_table LIMIT 5"
)

$headers = @{
    Authorization = "Bearer $Token"
    "Content-Type" = "application/json"
}

$base64Content = [Convert]::ToBase64String([Text.Encoding]::UTF8.GetBytes($SqlQuery))

$body = @{
    path = $NotebookPath
    language = "SQL"
    format = "SOURCE"
    content = $base64Content
} | ConvertTo-Json -Depth 3

Invoke-RestMethod -Method POST "$Host/api/2.0/workspace/import" -Headers $headers -Body $body
Write-Host "✅ Notebook imported: $NotebookPath"

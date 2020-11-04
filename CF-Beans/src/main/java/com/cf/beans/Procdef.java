package com.cf.beans;

public class Procdef {
    private String id;

    private Integer rev;

    private String category;

    private String name;

    private String key;

    private Integer version;

    private String deploymentId;

    private String resourceName;

    private String dgrmResourceName;

    private String description;

    private Byte hasStartFormKey;

    private Byte hasGraphicalNotation;

    private Integer suspensionState;

    private String tenantId;

    private String engineVersion;

    private Integer appVersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId == null ? null : deploymentId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getDgrmResourceName() {
        return dgrmResourceName;
    }

    public void setDgrmResourceName(String dgrmResourceName) {
        this.dgrmResourceName = dgrmResourceName == null ? null : dgrmResourceName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(Byte hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public Byte getHasGraphicalNotation() {
        return hasGraphicalNotation;
    }

    public void setHasGraphicalNotation(Byte hasGraphicalNotation) {
        this.hasGraphicalNotation = hasGraphicalNotation;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion == null ? null : engineVersion.trim();
    }

    public Integer getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Integer appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rev=").append(rev);
        sb.append(", category=").append(category);
        sb.append(", name=").append(name);
        sb.append(", key=").append(key);
        sb.append(", version=").append(version);
        sb.append(", deploymentId=").append(deploymentId);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", dgrmResourceName=").append(dgrmResourceName);
        sb.append(", description=").append(description);
        sb.append(", hasStartFormKey=").append(hasStartFormKey);
        sb.append(", hasGraphicalNotation=").append(hasGraphicalNotation);
        sb.append(", suspensionState=").append(suspensionState);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", engineVersion=").append(engineVersion);
        sb.append(", appVersion=").append(appVersion);
        sb.append("]");
        return sb.toString();
    }
}